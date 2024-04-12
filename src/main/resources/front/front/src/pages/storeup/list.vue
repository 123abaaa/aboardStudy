<template>
<div :style='{"border":"1px solid #ddd","padding":"20px","margin":"20px auto 0","borderRadius":"16px","background":"#fff","width":"1200px","position":"relative"}'>
<!--    <el-button :style='{"border":"1px solid #F56C6C","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"radial-gradient(circle, rgba(241,211,87,1) 0%, rgba(254,199,0,1) 100%)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">return</el-button>-->
  <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
    <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
      <el-breadcrumb-item>home page</el-breadcrumb-item>
      <el-breadcrumb-item>My favorites</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

  <el-card style="margin: 30px auto 0px auto;">
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
      <el-table-column prop="institutionName" label="College name">
        <template  slot-scope="scope">
          <a :href="scope.row.institutionUrl" target="_blank" style="text-decoration: none; color: #007AA1;">{{scope.row.institutionName}}</a>
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
        userId: localStorage.getItem('userId'),
      }
    },
    created() {
      this.getInstitutionList();
    },
    methods: {
      getInstitutionList() {
        this.$http.get('institution/findMyCollection', {params: Object.assign({'userId' : this.userId})}).then(res => {
          this.institutionEntityList = res.data.institutionEntityList;
        });
      },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
</style>
