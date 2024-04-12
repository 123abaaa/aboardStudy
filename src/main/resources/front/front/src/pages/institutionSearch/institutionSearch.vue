<template>

  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>School search</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card style="width: 60%; margin: 30px auto 0px auto;">
      <el-form label-width="120px" :inline="true">
        <el-form-item label="College name" style="width: 30%;">
          <el-input v-model="institutionName"></el-input>
        </el-form-item>
        <el-form-item label="College majors"  style="width: 45%;">
          <el-select placeholder="Please select the major of the university" v-model="collegeMajor" style="width: 300px;">
            <el-option v-for="collegeMajor in collegeMajorList" :label="collegeMajor.collegeMajor" :value="collegeMajor.collegeMajor"></el-option>
          </el-select>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" style="margin: auto 10px auto -60px;" @click="findInstitution()">query</el-button>
        <el-button type="warning" icon="el-icon-refresh" @click="reload()">Reset</el-button>
      </el-form>
    </el-card>

    <el-card class="box-card" style="width: 60%; margin: 20px auto 30px auto;">
      <el-table
          :data="institutionEntityList"
          stripe
          style="width: 100%; font-size: 16px;">
        <el-table-column
            prop="institutionRanking"
            label="ranking"
            width="120">
        </el-table-column>
        <el-table-column prop="institutionPicture" label="Avatar" width="150">
          <template slot-scope="scope">
            <img :src="scope.row.institutionPicture" :min-width="70" :height="70"/>
          </template>
        </el-table-column>
        <el-table-column prop="institutionName" label="College name" width="630">
          <template  slot-scope="scope">
            <a :href="scope.row.institutionUrl" target="_blank" style="text-decoration: none; color: #007AA1;">{{scope.row.institutionName}}</a>
          </template>
        </el-table-column>
        <el-table-column label="application">
          <template  slot-scope="scope">
            <el-button @click="applyFor(scope.row.institutionId)" type="success">application</el-button>
            <div @click="storeup(1, scope.row.institutionId)" v-show="scope.row.collectEntity == null || scope.row.collectEntity.collectFlag == 0" :style='{"cursor":"pointer","borderRadius":"20px"}'><i v-if="true" :style='{"color":"#ffb966","fontSize":"14px"}' class="el-icon-star-off"></i><span :style='{"color":"#ffb966","fontSize":"14px"}'>Click on my favorites</span></div>
            <div @click="storeup(0, scope.row.institutionId)" v-show="scope.row.collectEntity != null && scope.row.collectEntity.collectFlag == 1" :style='{"cursor":"pointer","borderRadius":"20px"}'><i v-if="true" :style='{"color":"#ffb966","fontSize":"14px"}' class="el-icon-star-on"></i><span :style='{"color":"#ffb966","fontSize":"14px"}'>Cancel Favorite</span></div>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      institutionEntityList: [],
      collegeMajorList: [],
      institutionName: '',
      collegeMajor: '',
      userId: localStorage.getItem('userId'),
    }
  },

  created() {
    this.getInstitutionList();
  },

  methods: {
    getInstitutionList() {
      this.$http.get('institution/findInstitution', {params: Object.assign({'userId' : this.userId})}).then(res => {
        this.institutionEntityList = res.data.institutionEntityList;
        this.collegeMajorList = res.data.collegeMajorList;
      });
    },

    findInstitution() {
      let institutionName = this.institutionName;
      let collegeMajor = this.collegeMajor;

      this.$http.get('institution/findInstitution', {params: Object.assign({'institutionName': institutionName, 'collegeMajor' : collegeMajor, 'userId' : this.userId})}).then(res => {
        this.institutionEntityList = res.data.institutionEntityList;
        this.collegeMajorList = res.data.collegeMajorList;
      });
    },

    reload() {
      this.institutionName = '';
      this.collegeMajor = '';
      this.getInstitutionList();
    },

    applyFor(institutionId) {
      this.$http.get('institution/applyFor', {params: Object.assign({'institutionId': institutionId, 'userId' : this.userId})}).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: res.data.message,
            type: 'success'
          });

          this.getInstitutionList();
        } else if (res.data.code == 400) {
          this.$message.error(res.data.message);
        }
      });
    },

    storeup(collectFlag, institutionId) {

      this.$http.get('institution/updateCollect', {params: Object.assign({'institutionId': institutionId, 'userId' : this.userId, 'collectFlag' : collectFlag})}).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: res.data.message,
            type: 'success',
            duration: 1500,
          });

          this.getInstitutionList();
        } else if (res.data.code == 400) {
          this.$message.error(res.data.message);
        }
      });
    },
  }
}
</script>

<style scoped>

</style>