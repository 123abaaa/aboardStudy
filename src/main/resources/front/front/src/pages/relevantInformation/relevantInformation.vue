<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Related information</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-card style="width: 60%; margin: 30px auto 30px auto;">
      <el-card v-for="relevantInformationEntity in relevantInformationEntityList" style="width: 98%; height: 130px; margin: 5px auto 15px auto; cursor: pointer;">
        <div @click="tumpDetails(relevantInformationEntity)">
          <el-row :gutter="130" style="height: 100%;">
            <el-col :span="3">
              <img :src="relevantInformationEntity.relevantInformationPicture" style="width: 120px; height: 100px;"/>
            </el-col>
            <el-col :span="20" >
              <div style="font-weight: bolder; margin-bottom: 10px;">{{ relevantInformationEntity.relevantInformationTitle }}</div>
              <div class="relevantInformationContentClass">{{ relevantInformationEntity.relevantInformationContent }}</div>
            </el-col>
          </el-row>
        </div>
      </el-card>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      relevantInformationEntityList: [],
    }
  },

  created() {
    this.getRelevantInformationEntityList();
  },

  methods: {
    getRelevantInformationEntityList() {
      this.$http.get('RelevantInformation/findRelevantInformation').then(res => {
        this.relevantInformationEntityList = res.data.relevantInformationEntityList;
      });
    },

    tumpDetails(relevantInformationEntity) {
      this.$router.push({ path: '/index/relevantInformationDetails', query: { 'relevantInformationEntity': relevantInformationEntity }});
    },
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .relevantInformationContentClass {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 3;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 14px;
  }
</style>