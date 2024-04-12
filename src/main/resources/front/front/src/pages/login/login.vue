<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(https://5b0988e595225.cdn.sohucs.com/images/20171206/c9bf6cab6b4642299e3ff2e8d4f87356.jpeg) no-repeat","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"30px 0px 30px 0px","boxShadow":"inset 0px 0px 90px 0px #f8ebd5,0 2px 6px #9c7c45","margin":"20px 0 0","borderColor":"#909399","background":"url() no-repeat center bottom,#fff","borderWidth":"4px","width":"500px","borderStyle":"solid double solid double","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 0 10px 0","fontSize":"24px","color":"#E6A23C","textAlign":"center","fontWeight":"bold"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 0 30px 0","fontSize":"24px","color":"#E6A23C","textAlign":"center","fontWeight":"bold"}'>Study Abroad Help Website Login</div>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 24px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#E6A23C"}'>Account：</div>
				<input :style='{"border":"1px solid #eacb96","padding":"0 10px","boxShadow":"0px 2px 0px #eacb96","color":"#999","borderRadius":"8px","background":"-webkit-linear-gradient(top,#fff,#f8ecd8)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="Please enter your account">
			</el-form-item>
			<el-form-item class="list-item" :style='{"width":"80%","margin":"0 auto 24px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"40px","fontSize":"14px","color":"#E6A23C"}'>password：</div>
				<input :style='{"border":"1px solid #eacb96","padding":"0 10px","boxShadow":"0px 2px 0px #eacb96","color":"#999","borderRadius":"8px","background":"-webkit-linear-gradient(top,#fff,#f8ecd8)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="Please enter password" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"20px auto"}'>
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"1px 2px 3px #aaa","margin":"0 5px","outline":"none","color":"#666","borderRadius":"20px","background":"radial-gradient(circle, rgba(160,207,255,1) 0%, rgba(64,158,255,1) 100%)","width":"128px","fontSize":"14px","height":"40px"}' @click="submitForm('loginForm')">Login</el-button>
				<el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0px","boxShadow":"1px 2px 3px #ccc","margin":"0 5px","outline":"none","color":"#999","borderRadius":"20px","background":"#fff","width":"128px","fontSize":"14px","height":"40px"}' @click="resetForm('loginForm')">Reset</el-button>
			</el-form-item>
			<div :style='{"width":"80%","margin":"20px auto"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 5px","fontSize":"14px","textDecoration":"none","color":"#E6A23C"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='yes'" v-for="(item, index) in roles" :key="index">register{{item.roleName.replace('register','')}}</router-link>
        <a style="cursor: pointer; margin: 0 5px; fontSize: 14px; textDecoration: none; color: #E6A23C;" @click="dialogVisible = true">Forgot password</a>

        <el-dialog
            title="reset password "
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
          <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}'>
            <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Account：</div>
            <el-input v-model="account"  placeholder="Please enter your account number" />
          </el-form-item>
          <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}'>
            <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>mailbox：</div>
            <el-input v-model="email"  placeholder="Please enter your email address" />
          </el-form-item>
          <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">cancel</el-button>
    <el-button type="primary" @click="fotgotPassword">reset password </el-button>
  </span>
        </el-dialog>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>


export default {

	data() {
		return {
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","check","modify","delete","Auditing","Gender ratio","Total number of homepage","Homepage statistics"],"menu":"user","menuJump":"list","tableName":"yonghu"}],"menu":"user management "},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["check","modify","delete","失物状态","状态比例","日失物量","View comments","Total number of homepage","Homepage statistics"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["check","modify","delete","日寻物量","View comments","Total number of homepage","Homepage statistics"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["check","modify","delete"],"menu":"Forum communication","tableName":"forum"}],"menu":"Forum communication"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["check","modify"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-rank","buttons":["new","check","modify","delete"],"menu":"Carousel management","tableName":"config"},{"appFrontIcon":"cuIcon-wenzi","buttons":["check","modify"],"menu":"System Introduction","tableName":"systemintro"},{"appFrontIcon":"cuIcon-news","buttons":["new","check","modify","delete"],"menu":"Website Announcement","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["new","check","modify","delete"],"menu":"Contact Consultant","tableName":"chat"}],"menu":"system management"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"no","hasFrontRegister":"no","roleName":"Administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["new","check","modify","delete","View comments"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","check","modify","delete","View comments"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete","Auditing"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"yes","hasFrontRegister":"yes","roleName":"user","tableName":"yonghu"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: 'Please enter your account', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'Please enter password', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}],
      dialogVisible: false,
      account: '',
      email: '',
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='yes') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},

    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("Please select the login user type");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/front/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                localStorage.setItem('counselor', res.data.YonghuEntity.counselor);
                localStorage.setItem('userId', res.data.YonghuEntity.id);
                this.$router.push('/index/center');
                this.$message({
                  message: 'Login successful',
                  type: 'success',
                  duration: 1500,
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
      },

      handleClose(done) {
        this.$confirm('Confirm Close？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
      },

      fotgotPassword() {
        if (this.account == '' || this.account == null || this.account == undefined) {
          this.$message.error('Please enter your account number');
          return false;
        }
        if (this.email == '' || this.email == null || this.email == undefined) {
          this.$message.error('Please enter your email address');
          return false;
        }

        let fotgotPasswordParams = {
          account: this.account,
          email: this.email,
        }
        this.loginForm.tableName = this.roles[0].tableName;
        this.$http.get(`${this.loginForm.tableName}/fotgotPassword`, {params: fotgotPasswordParams}).then(res => {
          if (res.data.code == 200) {
            this.$message({
              message: res.data.message,
              type: 'success'
            });
            this.dialogVisible = false;
            this.account = '';
            this.email = '';
          } else {
            this.$message.error(res.data.message);
          }
        });
      },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(https://5b0988e595225.cdn.sohucs.com/images/20171206/c9bf6cab6b4642299e3ff2e8d4f87356.jpeg) no-repeat;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #eacb96;
			border-radius: 8px;
			padding: 0 10px;
			box-shadow: 0px 2px 0px #eacb96;
			color: #999;
			background: -webkit-linear-gradient(top,#fff,#f8ecd8);
			width: 100%;
			font-size: 14px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #eacb96;
			border-radius: 8px;
			padding: 0 10px;
			box-shadow: 0px 2px 0px #eacb96;
			outline: none;
			color: #999;
			background: -webkit-linear-gradient(top,#fff,#f8ecd8);
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 160px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #F56C6C;
			border-color: #fd8a25;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #F56C6C;
			font-size: 14px;
		}
	}
</style>
