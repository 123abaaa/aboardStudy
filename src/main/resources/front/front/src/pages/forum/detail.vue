<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Forum communication</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card style="width: 60%; margin: 30px auto 0px auto;">
      <div class="section-content">
        <div class="content-title">{{detail.title}}</div>
        <div class="content-sub-title">Publisher：{{detail.username}}&nbsp;&nbsp;Release time：{{detail.addtime}}</div>
        <el-divider></el-divider>
        <div class="content-detail" v-html="detail.content"></div>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="height: 40px;line-height: 40px;color: #666;font-size: 18px;">Comment List</span>
            <el-button style="float: right;" icon="el-icon-plus" type="success" @click="dialogFormVisible = true">Click on comment</el-button>
          </div>
          <span v-for="item in commentList" :key="item.id">
          <div class="header-block">
            <el-avatar v-if="item.avatarurl" :size="50" :src="baseUrl + item.avatarurl"></el-avatar>
            <el-avatar v-if="!item.avatarurl" :size="50" :src="require('@/assets/touxiang.png')"></el-avatar>
            <span class="userinfo">user：{{item.username}}</span>
          </div>
          <div class="content-block-ask">
            {{item.content}}
          </div>
          <el-divider></el-divider>
        </span>
        </el-card>
      </div>
      <el-dialog title="Add comments" :visible.sync="dialogFormVisible">
        <el-form :model="form" :rules="rules" ref="form">
          <el-form-item label="comment" label-width="60px" prop="content">
            <el-input type="textarea" :rows="5" v-model="form.content" autocomplete="off" placeholder="Please enter a comment"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">cancel</el-button>
          <el-button type="primary" @click="addForum('form')">Confirm</el-button>
        </div>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
  export default {

    data() {
      return {
        baseUrl: '',
        detail: {},
        commentList: [],
        dialogFormVisible: false,
        form: {
          content: '',
          parentid: '',
          userid: localStorage.getItem('userid'),
          username: localStorage.getItem('username'),
          avatarurl: '',
        },
        rules: {
          content: [
            { required: true, message: 'Please enter a comment', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.detail = Object.assign({}, JSON.parse(this.$route.query.detailObj));
      this.getCommentList();
    },
    mounted() {
      this.form.parentid = this.detail.id;
    },

    methods: {
      getCommentList() {
        this.$http.get(`forum/list/${this.detail.id}`).then(res => {
          if (res.data.code == 0) {
            this.commentList = res.data.data.childs;
          }
        });
      },
      addForum(formName) {
        let sensitiveWords = "";
        let sensitiveWordsArr = [];
        if(sensitiveWords) {
            sensitiveWordsArr = sensitiveWords.split(",");
        }
        for(var i=0; i<sensitiveWordsArr.length; i++){
            
            var reg = new RegExp(sensitiveWordsArr[i],"g");
            
            if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
                
                this.form.content = this.form.content.replace(reg,"**");
            }
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.form.avatarurl = localStorage.getItem('headportrait')?localStorage.getItem('headportrait'):'';
            this.$http.post('forum/add', this.form).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  type: 'success',
                  message: 'Comment successful!',
                  duration: 1500,
                  onClose: () => {
                    this.form.content = '';
                    this.getCommentList();
                    this.dialogFormVisible = false;
                  }
                });
              }
            });
          } else {
            return false;
          }
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .section-content {
      margin-top: 30px;
  }
  .content-title {
      text-align: center;
      font-size: 22px;
      font-weight: bold;
  }
  .content-sub-title {
      text-align: center;
      margin-top: 20px;
      color: #888888;
      font-size: 14px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .header-block {
    height: 50px;
    line-height: 50px;
    display: flex;
  }
  .userinfo {
    align-self: center;
    margin-left: 15px;
  }
  .content-block-ask {
    margin-left: 65px;
    margin-top: 15px;
  }
  .content-detail img {
    max-width: 900px;
    height: auto;
  }
</style>
