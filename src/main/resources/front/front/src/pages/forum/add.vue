<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Forum communication</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card style="width: 60%; margin: 30px auto 0px auto;">
      <el-form class="add-update-preview" :model="form" :rules="rules" ref="form" label-width="80px">
        <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' label="title" prop="title">
          <el-input v-model="form.title" placeholder="Please enter a title"></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' label="type" prop="isdone">
          <el-radio-group v-model="form.isdone">
            <el-radio label="Open">公开</el-radio>
            <el-radio label="close">私人</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 8px 0","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' label="content" prop="content">
          <quill-editor ref="myTextEditor"
                        v-model="form.content"
                        :config="editorOption"
                        @ready="onEditorReady($event)">
          </quill-editor>
        </el-form-item>
        <el-form-item :style='{"padding":"0","margin":"20px 0 20px 0"}'>
          <el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 3px #aaa","margin":"0 20px 0 0","color":"#666","outline":"none","borderRadius":"20px","background":"radial-gradient(circle, rgba(248,152,152,1) 0%, rgba(245,108,108,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">{{this.isEdit ? 'modify' : 'Post'}} </el-button>
          <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"1px 2px 6px #ccc","margin":"0","color":"#999","outline":"none","borderRadius":"20px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">Reset</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  export default {

    data() {
      return {
        form: {
          title: '',
          isdone: 'Open',
          content: '',
          parentid: 0,
          userid: localStorage.getItem('userid'),
          username: localStorage.getItem('username')
        },
        editorOption: {
          modules: {
            toolbar: [
              ["bold", "italic", "underline", "strike"],
              ["blockquote", "code-block"],
              [{ header: 1 }, { header: 2 }],
              [{ list: "ordered" }, { list: "bullet" }],
              [{ script: "sub" }, { script: "super" }],
              [{ indent: "-1" }, { indent: "+1" }],
              [{ direction: "rtl" }],
              [{ size: ["small", false, "large", "huge"] }],
              [{ header: [1, 2, 3, 4, 5, 6, false] }],
              [{ color: [] }, { background: [] }],
              [{ font: [] }],
              [{ align: [] }],
              ["clean"],
              ["image", "video"]
            ]
          }
        },
        isEdit: false,
        rules: {
          title: [
            { required: true, message: 'Please enter a title', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      if (this.$route.query.id != undefined) {
        this.isEdit = true;
        this.form = Object.assign({}, JSON.parse(this.$route.query.editObj));
      }
    },

    methods: {
      onEditorReady(editor) {
        editor.root.setAttribute('data-placeholder', "Please enter the content...");
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(`forum/${this.isEdit ? 'update' : 'add'}`, this.form).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: `${this.isEdit ? 'modify' : 'release'}success`,
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    if (this.isEdit) {
                      this.$router.push('/index/myForumList');
                    } else {
                      this.$router.push('/index/forum');
                    }
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .add-update-preview .el-form-item /deep/ .el-form-item__label {
        padding: 0 10px 0 0;
        color: #666;
        font-weight: 500;
        width: 80px;
        font-size: 14px;
        line-height: 40px;
        text-align: right;
      }
  
  .add-update-preview .el-form-item /deep/ .el-form-item__content {
    margin-left: 80px;
  }
  
  .add-update-preview .el-input /deep/ .el-input__inner {
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 0 12px;
        outline: none;
        color: #999;
        background: #fff;
        width: 400px;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview .el-select /deep/ .el-input__inner {
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 0 10px;
        outline: none;
        color: #999;
        background: #f9f9f9;
        width: 200px;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview .el-date-editor /deep/ .el-input__inner {
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 0 10px 0 30px;
        outline: none;
        color: #999;
        background: #f9f9f9;
        width: 200px;
        font-size: 14px;
        height: 40px;
      }
  
  .add-update-preview /deep/ .el-upload--picture-card {
  	background: transparent;
  	border: 0;
  	border-radius: 0;
  	width: auto;
  	height: auto;
  	line-height: initial;
  	vertical-align: middle;
  }
  
  .add-update-preview /deep/ .upload .upload-img {
        border: 1px solid #ccc;
        cursor: pointer;
        border-radius: 6px;
        color: #999;
        background: #f9f9f9;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview /deep/ .el-upload-list .el-upload-list__item {
        border: 1px solid #ccc;
        cursor: pointer;
        border-radius: 6px;
        color: #999;
        background: #f9f9f9;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview /deep/ .el-upload .el-icon-plus {
        border: 1px solid #ccc;
        cursor: pointer;
        border-radius: 6px;
        color: #999;
        background: #f9f9f9;
        width: 200px;
        font-size: 32px;
        line-height: 120px;
        text-align: center;
        height: auto;
      }
  
  .add-update-preview .el-textarea /deep/ .el-textarea__inner {
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 12px;
        outline: none;
        color: #999;
        background: #f9f9f9;
        width: 400px;
        font-size: 14px;
        min-height: 120px;
      }
</style>
