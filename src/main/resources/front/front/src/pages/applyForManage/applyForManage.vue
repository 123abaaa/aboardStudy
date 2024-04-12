<template>
  <div>
    <div :style='{"padding":"12px","boxShadow":"0 0px 6px #999","margin":"0px auto","borderColor":"#fff","borderRadius":"0px","background":"linear-gradient(180deg, #eee 0%, #fff 32%, #eee 100%)","borderWidth":"1px 0 1px 0","width":"100%","borderStyle":"solid"}' class="breadcrumb-preview">
      <el-breadcrumb :separator="'Ξ'" :style='{"width":"1200px","margin":"0 auto","fontSize":"14px","lineHeight":"1"}'>
        <el-breadcrumb-item>home page</el-breadcrumb-item>
        <el-breadcrumb-item>Application Management</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

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
        <el-table-column prop="institutionName" label="College name" width="580">
          <template  slot-scope="scope">
            <a :href="scope.row.institutionUrl" target="_blank" style="text-decoration: none; color: #007AA1;">{{scope.row.institutionName}}</a>
          </template>
        </el-table-column>
        <el-table-column label="Application progress">
          <template  slot-scope="scope">
            <el-button @click="openSchedule(scope.row.applyForEntity.schedule)" type="success">Application progress inquiry</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="Application progress" :visible.sync="dialogTableVisible">
        <el-steps :active="stepsSchedule">
          <el-step title="stores reserve"></el-step>
          <el-step title="Material review"></el-step>
          <el-step title="Submit application"></el-step>
          <el-step title="Application results"></el-step>
          <el-step title="Confirm offer"></el-step>
          <el-step title="Obtain CAS"></el-step>
        </el-steps>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      institutionEntityList: [],
      userId: localStorage.getItem('userId'),
      dialogTableVisible: false,
      stepsSchedule: 1,
    }
  },

  created() {
    this.findApplyForManage();
  },

  methods: {
    findApplyForManage() {
      this.$http.get('institution/findApplyForManage', {params: Object.assign({'userId' : this.userId})}).then(res => {
        this.institutionEntityList = res.data.institutionEntityList;
      });
    },

    openSchedule(schedule) {
      this.dialogTableVisible = true;
      this.stepsSchedule = schedule;
    },
  },
}
</script>

<style scoped>

</style>