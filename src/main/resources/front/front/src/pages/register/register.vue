<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(https://5b0988e595225.cdn.sohucs.com/images/20171206/c9bf6cab6b4642299e3ff2e8d4f87356.jpeg) no-repeat","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"30px 100px 80px 80px","boxShadow":"inset 0px 0px 90px 0px #f8ebd5,0 2px 6px #9c7c45","margin":"0","borderColor":"#E6A23C","background":"url() no-repeat center bottom,#fff","borderWidth":"4px","width":"auto","minWidth":"800px","borderStyle":"solid double solid double","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 0 10px 0","fontSize":"20px","color":"#E6A23C","textAlign":"center","fontWeight":"bold"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 0 24px 0","fontSize":"20px","color":"#E6A23C","textAlign":"center","fontWeight":"bold"}'>Study Abroad Help Website register</div>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="counselor">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>role：</div>
        <el-radio v-model="registerForm.counselor" label="1" value="1">Student users</el-radio>
        <el-radio v-model="registerForm.counselor" label="0" value="0">Study abroad consultant</el-radio>
      </el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="zhanghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Account：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="Please enter your account number" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>password：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="Please enter password" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Confirm password：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="Please enter your password again" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>name：</div>
				<el-input v-model="registerForm.xingming"  placeholder="Please enter your name" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="nianling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Age：</div>
				<el-input v-model="registerForm.nianling"  placeholder="Please enter your age" />
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Gender：</div>
                <el-select v-model="registerForm.xingbie" placeholder="Please select gender" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>mobile phone：</div>
				<el-input v-model="registerForm.shouji"  placeholder="Please enter your phone number" />
			</el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="email">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>mailbox：</div>
        <el-input v-model="registerForm.email"  placeholder="Please enter your email address" />
      </el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu' && registerForm.counselor == '1'" prop="undergraduateinstitution">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Undergraduate institutions：</div>
        <el-input v-model="registerForm.undergraduateinstitution"  placeholder="Please enter your undergraduate institution" />
      </el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu' && registerForm.counselor == '1'" prop="divideequally">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Equal distribution：</div>
        <el-input v-model="registerForm.divideequally"  placeholder="Please enter the average score" />
      </el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu' && registerForm.counselor == '1'" prop="ieltsscore">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>IELTS score：</div>
        <el-input v-model="registerForm.ieltsscore"  placeholder="Please enter your IELTS score" />
      </el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu' && registerForm.counselor == '0'" prop="counselorinstitution">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>consultative body：</div>
        <el-input v-model="registerForm.counselorinstitution"  placeholder="Please enter the consulting agency" />
      </el-form-item>
      <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu' && registerForm.counselor == '0'" prop="workingyears">
        <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Years of work experience：</div>
        <el-input v-model="registerForm.workingyears"  placeholder="Please enter your work experience" />
      </el-form-item>
			<el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Avatar：</div>
                <file-upload
					tip="Click to upload avatar"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0px","boxShadow":"1px 2px 3px #aaa","margin":"12px 16px 5px 236px","color":"#666","display":"inline-block","outline":"none","borderRadius":"20px","background":"radial-gradient(circle, rgba(160,207,255,1) 0%, rgba(64,158,255,1) 100%)","width":"128px","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('registerForm')">register</el-button>
			<el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0px","boxShadow":"1px 2px 3px #ccc","margin":"12px auto 5px","color":"#999","display":"inline-block","outline":"none","borderRadius":"20px","background":"#fff","width":"128px","fontSize":"16px","height":"40px"}' @click="resetForm('registerForm')">Reset</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#E6A23C","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Existing account login</router-link>
		</el-form>
    </div>
  </div>
</template>

<script>

export default {

    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                xingbie: '',
        counselor: '1',
            },
			rules: {},
            yonghuxingbieOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('yonghu' == this.tableName) {
        this.rules.zhanghao = [{ required: true, message: 'Please enter your account number', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.mima = [{ required: true, message: 'Please enter password', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.xingming = [{ required: true, message: 'Please enter your name', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.yonghuxingbieOptions = "male,female".split(',');
      if ('yonghu' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.email = [{ required: true, message: 'Please enter your email address', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.undergraduateinstitution = [{ required: true, message: 'Please enter your undergraduate institution', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.divideequally = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.ieltsscore = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.counselorinstitution = [{ required: true, message: 'Please enter the consulting agency', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.workingyears = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
    },

    methods: {

      getUUID () {
        return new Date().getTime();
      },

      yonghutouxiangUploadChange(fileUrls) {console.log(this.$config.baseUrl);console.log(new RegExp(this.$config.baseUrl,"g"));console.log(fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),""));
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },




      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`The two password inputs are inconsistent`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: 'login was successful',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
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
	.container {
		position: relative;
		background: url(https://5b0988e595225.cdn.sohucs.com/images/20171206/c9bf6cab6b4642299e3ff2e8d4f87356.jpeg) no-repeat;

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #eacb96;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 0px 2px 0px #eacb96;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#f8ecd8);
						width: 100%;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #eacb96;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 0px 2px 0px #eacb96;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#f8ecd8);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eacb96;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 0px 2px 0px #eacb96;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#f8ecd8);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #eacb96;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 0px 2px 0px #eacb96;
						outline: none;
						color: #999;
						background: -webkit-linear-gradient(top,#fff,#f8ecd8);
						width: 288px;
						font-size: 14px;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #edbe6d;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #E6A23C;
		  		  background: -webkit-linear-gradient(top,#fff,#f8ecd8);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #edbe6d;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #E6A23C;
		  		  background: -webkit-linear-gradient(top,#fff,#f8ecd8);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #edbe6d;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #E6A23C;
		  		  background: -webkit-linear-gradient(top,#fff,#f8ecd8);
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 120px;
		  		  text-align: center;
		  		  height: 120px;
		  		}
	}
</style>
