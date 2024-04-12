<template>
<div class="center-preview">
  <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
    <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
      <el-breadcrumb-item>home page</el-breadcrumb-item>
      <el-breadcrumb-item>Personal Center</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

  <el-card style="width: 60%; margin: 30px auto 0px auto;">
    <el-tabs tab-position="left" :style='{"border":"1px solid #ddd","width":"100%","padding":"30px 20px","margin":"20px auto 0 auto","borderRadius":"16px","background":"#fff"}' @tab-click="handleClick">
      <el-tab-pane label="Personal Center">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="250px">
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="Account" prop="zhanghao">
            <el-input v-model="sessionForm.zhanghao" placeholder="Account" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="password" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="name" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="Age" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="Age" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="Gender">
            <el-select v-model="sessionForm.xingbie" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="mobile phone" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="mobile phone" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="mailbox" prop="email">
            <el-input v-model="sessionForm.email" placeholder="mailbox" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu' && counselor == '1'" label="Undergraduate institutions" prop="undergraduateinstitution">
            <el-input v-model="sessionForm.undergraduateinstitution" placeholder="Undergraduate institutions" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu' && counselor == '1'" label="Equal distribution" prop="divideequally">
            <el-input v-model="sessionForm.divideequally" placeholder="Equal distribution" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu' && counselor == '1'" label="IELTS score" prop="ieltsscore">
            <el-input v-model="sessionForm.ieltsscore" placeholder="IELTS score" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu' && counselor == '0'" label="consultative body" prop="counselorinstitution">
            <el-input v-model="sessionForm.counselorinstitution" placeholder="consultative body" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu' && counselor == '0'" label="Years of work experience" prop="workingyears">
            <el-input v-model="sessionForm.workingyears" placeholder="Years of work experience" ></el-input>
          </el-form-item>
          <el-form-item :style='{"border":"1px solid #dfdfdf","padding":"10px","boxShadow":"1px 2px 3px #eee","margin":"0 0 10px","borderRadius":"8px","background":"linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%)"}' v-if="userTableName=='yonghu'" label="Avatar">
            <el-upload
                class="avatar-uploader"
                :action="uploadUrl"
                :headers="headers"
                :show-file-list="false"
                :on-success="yonghutouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #999","cursor":"pointer","color":"#999","borderRadius":"6px","textAlign":"center","background":"#f9f9f9","width":"200px","fontSize":"32px","lineHeight":"100px","height":"auto"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"20px 0 20px 0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","boxShadow":"1px 2px 3px #aaa","margin":"0 20px 0 0","color":"#666","outline":"none","borderRadius":"20px","background":"radial-gradient(circle, rgba(248,152,152,1) 0%, rgba(245,108,108,1) 100%)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">Update information</el-button>
            <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","boxShadow":"1px 2px 3px #ccc","margin":"0","color":"#999","outline":"none","borderRadius":"20px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">Logout Login</el-button>
          </el-form-item>
        </el-form>

        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                      style="width: 60px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/weixin.png')"
                      fit="fill"></el-image>
                  <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                      style="width: 60px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/zhifubao.png')"
                      fit="fill"></el-image>
                  <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                      style="width: 120px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/jianshe.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                      style="width: 126px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/nongye.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                      style="width: 140px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/zhongguo.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                      style="width: 120px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/jiaotong.png')"
                      fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">cancel</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                      style="width: 60px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/weixin.png')"
                      fit="fill"></el-image>
                  <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                      style="width: 60px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/zhifubao.png')"
                      fit="fill"></el-image>
                  <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                      style="width: 120px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/jianshe.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                      style="width: 126px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/nongye.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                      style="width: 140px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/zhongguo.png')"
                      fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                      style="width: 120px; height: 60px;vertical-align: middle;"
                      :src="require('@/assets/jiaotong.png')"
                      fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">cancel</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="My Posts"></el-tab-pane>
      <el-tab-pane v-if="counselor == '1'" label="My favorites"></el-tab-pane>
    </el-tabs>
  </el-card>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {

    data() {
      return {
        title: 'Personal Center',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
        counselor: localStorage.getItem('counselor'),
      }
    },
    created() {
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'zhanghao', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xingming', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'shouji', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'email', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'undergraduateinstitution', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'divideequally', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'ieltsscore', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'counselorinstitution', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'workingyears', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'sfsh', null);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.sessionForm, 'shhf', null);
      }

      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'zhanghao', [{ required: true, message: 'Please enter your account number', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: 'Please enter password', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'xingming', [{ required: true, message: 'Please enter your name', trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'email', [{ required: true, message: 'Please enter your email address', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'undergraduateinstitution', [{ required: true, message: 'Please enter your undergraduate institution', trigger: 'blur' }]);
      }
      if ('yonghu' == this.tableName) {
        this.$set(this.rules, 'divideequally', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
      if ('yonghu' == this.tableName) {
        this.$set(this.rules, 'ieltsscore', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
      if ('yonghu' == this.tableName) {
        this.$set(this.rules, 'counselorinstitution', [{ required: true, message: 'Please enter the consulting agency', trigger: 'blur' }]);
      }
      if ('yonghu' == this.tableName) {
        this.$set(this.rules, 'workingyears', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },

    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = 'male,female'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: 'Update successful',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      yonghutouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('yonghu' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == 'yes') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "yes"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case 'Personal Center':
            tab.$router.push('/index/center');
            break;
          case 'My Posts':
            tab.$router.push('/index/myForumList');
            break;
          case 'My favorites':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: 'Login successful',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	border-radius: 0 12px 0 0;
	padding: 16px 0 0;
	box-shadow: 0px 0px 0px #bbb;
	margin: 0 10px 0 0;
	background: #fff;
	width: 226px;
	border-color: #F56C6C;
	border-width: 4px 4px 0 0;
	position: relative;
	float: right;
	border-style: solid dashed;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 0 12px 8px 12px;
  	color: #333;
  	white-space: nowrap;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	text-overflow: ellipsis;
  	border-radius: 30px;
  	box-shadow: 1px 2px 1px #bbb;
  	overflow: hidden;
  	background: linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%);
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border-radius: 10px;
  	padding: 0 10px;
  	box-shadow: 1px 2px 1px #bbb;
  	margin: 0 12px 8px 12px;
  	color: #333;
  	background: linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border-radius: 10px;
  	padding: 0 10px;
  	box-shadow: 1px 2px 1px #bbb;
  	margin: 0 12px 8px 12px;
  	color: #333;
  	background: linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 0 0 0 10px;
  	background: none;
  	width: 860px;
  	float: left;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 80px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 80px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #999;
  	background: #f9f9f9;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #999;
  	background: #f9f9f9;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
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
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px dashed #999;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #999;
  	background: #f9f9f9;
  	width: 200px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	margin: 0 8px 0 0;
  	color: #999;
  	background: #f9f9f9;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
