<template>
  <div class="main-content">
      <el-form class="center-form-pv" :style='{"margin":"0 200px 20px"}' :inline="true">
        <el-row :style='{"display":"block"}' >
          <div :style='{"margin":"0 15px 0 0","display":"inline-block"}'>
            <label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"600","height":"40px"}' class="item-label">User Name</label>
            <el-input v-model="xingming" placeholder="User Name" clearable></el-input>
          </div>
          <div :style='{"margin":"0 15px 0 0","display":"inline-block"}'>
            <label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"600","height":"40px"}' class="item-label">College name</label>
            <el-input v-model="institutionName" placeholder="College name" clearable></el-input>
          </div>
          <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(162, 153, 136, 1)","width":"auto","fontSize":"14px","height":"40px"}' type="success" @click="search()">query</el-button>
        </el-row>
      </el-form>

      <!-- <div> -->
      <el-table class="tables"
                :stripe='false'
                :style='{"padding":"0","borderColor":"#666","margin":"0 0 0 200px ","borderWidth":"1px","background":"#fff","width":"89%","borderStyle":"solid"}'
                v-if="isAuth('applyForManage','check')"
                :data="institutionEntityList"
                v-loading="dataListLoading"
                @selection-change="selectionChangeHandler">
        <el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
<!--        <el-table-column :resizable='true' :sortable='false' label="index" type="index" width="50" />-->
        <el-table-column :resizable='true' :sortable='false'
                         prop="institutionRanking"
                         label="College Ranking" width="100">
          <template slot-scope="scope">
            {{scope.row.institutionRanking}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         prop="institutionName"
                         label="College name" width="250">
          <template slot-scope="scope">
            {{scope.row.institutionName}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false' prop="institutionPicture" width="200" label="College images">
          <template slot-scope="scope">
            <div v-if="scope.row.institutionPicture">
              <img  :src="scope.row.institutionPicture.split(',')[0]" width="100" height="100">

            </div>
            <div v-else>No images</div>
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         prop="xingming"
                         label="Requesting user name" width="120">
          <template slot-scope="scope">
            {{scope.row.yonghuEntity.xingming}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         prop="undergraduateinstitution"
                         label="Undergraduate institutions" width="250">
          <template slot-scope="scope">
            {{scope.row.yonghuEntity.undergraduateinstitution}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         prop="divideequally"
                         label="Equal distribution" width="100">
          <template slot-scope="scope">
            {{scope.row.yonghuEntity.divideequally}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         prop="ieltsscore"
                         label="IELTS score" width="100">
          <template slot-scope="scope">
            {{scope.row.yonghuEntity.ieltsscore}}
          </template>
        </el-table-column>
        <el-table-column :resizable='true' :sortable='false'
                         label="Application progress" width="170">
          <template slot-scope="scope">
            <span v-if="scope.row.applyForEntity.schedule == 1">stores reserve</span>
            <span v-if="scope.row.applyForEntity.schedule == 2">Material review</span>
            <span v-if="scope.row.applyForEntity.schedule == 3">Submit application</span>
            <span v-if="scope.row.applyForEntity.schedule == 4">Application results</span>
            <span v-if="scope.row.applyForEntity.schedule == 5">Confirm offer</span>
            <span v-if="scope.row.applyForEntity.schedule == 6">Obtain CAS</span>
          </template>
        </el-table-column>
        <el-table-column label="operation">
          <template slot-scope="scope">
            <el-button :style='{"border":"1px solid #AAAAAA","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#AAAAAA","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('applyForManage','modify')" type="primary" size="mini" @click="openUpdateScheduleDialog(scope.row.applyForEntity.applyforid, scope.row.applyForEntity.schedule)">Modify Progress</el-button>
          </template>
        </el-table-column>
      </el-table>

    <el-dialog title="Modify application progress" :visible.sync="dialogFormVisible">
      <el-form>
        <el-form-item label="Application progress" :label-width="formLabelWidth">
          <el-select v-model="schedule" placeholder="Please select the application progress">
            <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">cancel</el-button>
        <el-button type="primary" @click="updateSchedule()">Confirm</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      xingming: '',
      institutionName: '',
      options: [
        {
          value: 1,
          label: 'stores reserve'
        },
        {
          value: 2,
          label: 'Material review'
        },
        {
          value: 3,
          label: 'Submit application'
        },
        {
          value: 4,
          label: 'Application results'
        },
        {
          value: 5,
          label: 'Confirm offer'
        },
        {
          value: 6,
          label: 'Obtain CAS'
        },
      ],
      institutionEntityList: [],
      dialogFormVisible: false,
      formLabelWidth: '180px',
      applyforid: 0,
      schedule: 1,
      counselorid: this.$storage.get("counselorid"),

    };
  },

  created() {
    this.findApplyForManageByCounselor();
  },

  methods: {
    findApplyForManageByCounselor() {
      this.$http.get('institution/findApplyForManageByCounselor', {params: Object.assign({'counselorid' : this.counselorid})}).then(res => {
        this.institutionEntityList = res.data.institutionEntityList;
      });
    },

    search() {
      this.$http.get('institution/findApplyForManageByCounselor', {params: Object.assign({'counselorid' : this.counselorid, 'xingming' : this.xingming, 'institutionName' : this.institutionName})}).then(res => {
        this.institutionEntityList = res.data.institutionEntityList;
      });
    },

    openUpdateScheduleDialog(applyforid, schedule) {
      this.applyforid = applyforid;
      this.schedule = schedule;
      this.dialogFormVisible = true;
    },

    updateSchedule() {
      this.$http.get('institution/updateSchedule', {params: Object.assign({'applyforid' : this.applyforid, 'schedule' : this.schedule})}).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: res.data.message,
            type: 'success'
          });
          this.dialogFormVisible = false;
          this.findApplyForManageByCounselor();
        } else if (res.data.code == 400) {
          this.$message.error(res.data.message);
        }
      });
    },
  },
}
</script>

<style lang="scss" scoped>

.center-form-pv {
  .el-date-editor.el-input {
    width: auto;
  }
}

.el-input {
  width: auto;
}

// form
.center-form-pv .el-input /deep/ .el-input__inner {
  border: 0;
  background-color: #fff;
  border-radius: 4px;
  padding: 0 12px;
  outline: none;
  background-size: 100% 100%;
  color: rgba(0, 0, 0, 1);
  width: 140px;
  font-size: 14px;
  background-image: url(http://codegen.caihongy.cn/20220731/71abcaa4c11140228910cbac764a8355.png);
  height: 40px;
}

.center-form-pv .el-select /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 10px;
  outline: none;
  background-size: 100% 100%;
  color: rgba(0, 0, 0, 1);
  width: 130px;
  font-size: 14px;
  background-image: url(http://codegen.caihongy.cn/20220731/71abcaa4c11140228910cbac764a8355.png);
  text-align: center;
  height: 40px;
}

.center-form-pv .el-date-editor /deep/ .el-input__inner {
  border: 0;
  border-radius: 4px;
  padding: 0 10px 0 30px;
  outline: none;
  background-size: 100% 100%;
  color: rgba(0, 0, 0, 1);
  width: 140px;
  font-size: 14px;
  background-image: url(http://codegen.caihongy.cn/20220731/71abcaa4c11140228910cbac764a8355.png);
  height: 40px;
}

// table
.el-table /deep/ .el-table__header-wrapper thead {
  color: #fff;
  font-weight: 500;
  width: 100%;
}

.el-table /deep/ .el-table__header-wrapper thead tr {
  background: #fff;
}

.el-table /deep/ .el-table__header-wrapper thead tr th {
  padding: 12px 0;
  background: rgba(162, 153, 136, 1);
  border-color: #666;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
  padding: 0 10px;
  word-wrap: normal;
  word-break: break-all;
  white-space: normal;
  font-weight: bold;
  display: inline-block;
  vertical-align: middle;
  width: 100%;
  line-height: 24px;
  position: relative;
  text-overflow: ellipsis;
}


.el-table /deep/ .el-table__body-wrapper tbody {
  width: 100%;
}

.el-table /deep/ .el-table__body-wrapper tbody tr {
  background: #fff;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td {
  padding: 12px 0;
  color: #999;
  background: #fff;
  border-color: #666;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}


.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
  padding: 12px 0;
  color: #000;
  background: rgba(162, 153, 136, 0.32);
  border-color: #666;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td {
  padding: 12px 0;
  color: #999;
  background: #fff;
  border-color: #666;
  border-width: 0 1px 1px 0;
  border-style: solid;
  text-align: center;
}

.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
  padding: 0 10px;
  overflow: hidden;
  word-break: break-all;
  white-space: normal;
  line-height: 24px;
  text-overflow: ellipsis;
}

// pagination
.main-content .el-pagination /deep/ .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .btn-prev {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

.main-content .el-pagination /deep/ .btn-next {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

.main-content .el-pagination /deep/ .btn-prev:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .btn-next:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

.main-content .el-pagination /deep/ .el-pager .number {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pager .number:hover {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #333;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pager .number.active {
  cursor: default;
  padding: 0 4px;
  margin: 0 5px;
  color: #FFF;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: rgba(162, 153, 136,.5);
  text-align: center;
  min-width: 30px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 25px 0 8px;
  color: #606266;
  display: inline-block;
  font-size: 13px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
  cursor: pointer;
  color: #C0C4CC;
  width: 25px;
  font-size: 14px;
  line-height: 28px;
  text-align: center;
}

.main-content .el-pagination /deep/ .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
  border-radius: 3px;
  padding: 0 2px;
  margin: 0 2px;
  display: inline-block;
  width: 50px;
  font-size: 14px;
  line-height: 18px;
  position: relative;
  text-align: center;
  height: 28px;
}

.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 3px;
  color: #606266;
  display: inline-block;
  font-size: 14px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}
</style>