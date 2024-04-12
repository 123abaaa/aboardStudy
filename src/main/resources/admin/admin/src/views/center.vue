<template>
  <div>
    <el-form
	  :style='{"borderRadius":"6px","padding":"30px","margin":"0 0 0 220px"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="140px"
    >  
     <el-row>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="Account" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" readonly              placeholder="Account" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="name" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="name" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="Age" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="Age" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'"  label="Gender" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="Please select gender">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="mobile phone" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="mobile phone" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'" label="Avatar" prop="touxiang">
          <file-upload
          tip="Click to upload avatar"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="user name" prop="username">
			<el-input v-model="ruleForm.username" placeholder="user name"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button :style='{"border":"2px solid rgba(193, 44, 44, 1)","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(193, 44, 44, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">Modify</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>

import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "male,female".split(',')
  },
  methods: {
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.zhanghao)&& 'yonghu'==this.flag){
        this.$message.error('Account cannot be empty');
        return
      }
      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('Password cannot be empty');
        return
      }
      if((!this.ruleForm.xingming)&& 'yonghu'==this.flag){
        this.$message.error('Name cannot be empty');
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`Age should be entered as an integer`);
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`Phone should be entered in phone format`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`The username cannot be empty`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Successfully modified information",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 600;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 100px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 100px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
