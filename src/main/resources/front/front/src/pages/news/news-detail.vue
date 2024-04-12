<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Website Announcement</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card class="box-card" style="width: 60%; margin: 20px auto 30px auto;">
      <div class="section-content">
        <div class="content-title">{{detail.title}}</div>
        <div class="content-sub-title">Release time：{{detail.addtime}}</div>
        <el-divider></el-divider>
        <div class="content-detail" v-html="detail.content"></div>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {

    data() {
      return {
        detail: {},
      }
    },
    created() {
      this.detail = Object.assign({}, JSON.parse(this.$route.query.detailObj));
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
</style>