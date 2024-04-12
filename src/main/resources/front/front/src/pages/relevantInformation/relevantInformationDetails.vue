<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Related information</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card style="width: 60%; margin: 30px auto 30px auto;">
      <div style="width: 100%; text-align: center; font-size: 25px; font-weight: bolder; margin-bottom: 20px;">{{ relevantInformationEntity.relevantInformationTitle }}</div>
      <div style="width: 100%; text-align: center; font-size: 15px; color: #888888;">Release time:{{ relevantInformationEntity.releaseTime }}</div>
      <el-divider></el-divider>
      <div>{{ relevantInformationEntity.relevantInformationContent }}</div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      relevantInformationEntity: {},
    }
  },

  created() {
    this.relevantInformationEntity = this.$route.query.relevantInformationEntity;
  },
}
</script>

<style scoped>

</style>