<template>
  <div class="main-content">
    <el-form class="center-form-pv" :style='{"margin":"0 200px 20px"}' :inline="true">
      <el-row :style='{"display":"block"}' >
        <div :style='{"margin":"0 15px 0 0","display":"inline-block"}'>
          <label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"600","height":"40px"}' class="item-label">message header</label>
          <el-input v-model="biaoti" placeholder="message header" clearable></el-input>
        </div>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(162, 153, 136, 1)","width":"auto","fontSize":"14px","height":"40px"}' type="success" @click="search()">query</el-button>
      </el-row>

      <el-row :style='{"margin":"20px 0","display":"flex"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"20px","background":"rgba(162, 153, 136, 1)","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('relevantInformation','new')" type="success" @click="openAddDetails()">new</el-button>
      </el-row>
    </el-form>

    <!-- <div> -->
    <el-table class="tables"
              :stripe='false'
              :style='{"padding":"0","borderColor":"#666","margin":"0 0 0 200px ","borderWidth":"1px","background":"#fff","width":"89%","borderStyle":"solid"}'
              v-if="isAuth('relevantInformation','check')"
              :data="relevantInformationEntityList"
              v-loading="dataListLoading"
              @selection-change="selectionChangeHandler">
      <el-table-column :resizable='true' :sortable='false' prop="relevantInformationPicture" width="200" label="Information images">
        <template slot-scope="scope">
          <div v-if="scope.row.relevantInformationPicture">
            <img v-if="scope.row.relevantInformationPicture.substring(0,4)=='http'" :src="scope.row.relevantInformationPicture.split(',')[0]" width="100" height="100">
            <img v-else :src="$base.url+scope.row.relevantInformationPicture.split(',')[0]" width="100" height="100">
          </div>
          <div v-else>No images</div>
        </template>
      </el-table-column>
      <el-table-column :resizable='true' :sortable='false'
                       prop="relevantInformationTitle"
                       label="message header" width="300">
        <template slot-scope="scope">
          {{scope.row.relevantInformationTitle}}
        </template>
      </el-table-column>
      <el-table-column :resizable='true' :sortable='false'
                       prop="relevantInformationContent"
                       label="information content" width="750">
        <template slot-scope="scope">
          <div class="relevantInformationContentClass">{{scope.row.relevantInformationContent}}</div>
        </template>
      </el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button :style='{"border":"1px solid #AAAAAA","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#AAAAAA","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('relevantInformation','check')" type="success" size="mini" @click="openDetails(scope.row.relevantInformationTitle, scope.row.relevantInformationContent)">details</el-button>
          <el-button :style='{"border":"1px solid #AAAAAA","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#AAAAAA","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('relevantInformation','modify')" type="primary" size="mini" @click="openUpdateDetails(scope.row.relevantInformationId, scope.row.relevantInformationPicture, scope.row.relevantInformationTitle, scope.row.relevantInformationContent)"">modify</el-button>
          <el-button :style='{"border":"1px solid #AAAAAA","cursor":"pointer","padding":"0 24px","margin":"0 10px 5px 0","outline":"none","color":"#AAAAAA","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('relevantInformation','delete') " type="danger" size="mini" @click="deleteDetails(scope.row.relevantInformationId)">delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Related information details" :visible.sync="detailsDialog">
      <div style="width: 100%; text-align: center; font-weight: bolder; font-size: 22px; margin-bottom: 30px;">{{ relevantInformationTitle }}</div>
      <div>{{ relevantInformationContent }}</div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="detailsDialog = false">cancel</el-button>
      </div>
    </el-dialog>

    <el-dialog title="Add relevant information" :visible.sync="addDetailsDialog">
      <el-form ref="form" label-width="220px">
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" label="Related information images" prop="relevantInformationPicture">
          <file-upload
              tip="Click to upload avatar"
              action="file/upload"
              :limit="3"
              :multiple="true"
              :fileUrls="relevantInformationPicture?relevantInformationPicture:''"
              @change="relevantInformationPictureUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item label="Related Information Title">
          <el-input v-model="relevantInformationTitle"></el-input>
        </el-form-item>
        <el-form-item label="Related information content">
          <el-input type="textarea" v-model="relevantInformationContent"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addDetailsDialog = false">cancel</el-button>
        <el-button type="primary" @click="addDetails()">Add</el-button>
      </div>
    </el-dialog>

    <el-dialog title="Add relevant information" :visible.sync="updateDetailsDialog">
      <el-form ref="form" label-width="220px">
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" label="Related information images" prop="relevantInformationPicture">
          <file-upload
              tip="Click to upload avatar"
              action="file/upload"
              :limit="3"
              :multiple="true"
              :fileUrls="relevantInformationPicture?relevantInformationPicture:''"
              @change="relevantInformationPictureUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item label="Related Information Title">
          <el-input v-model="relevantInformationTitle"></el-input>
        </el-form-item>
        <el-form-item label="Related information content">
          <el-input type="textarea" v-model="relevantInformationContent"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateDetailsDialog = false">cancel</el-button>
        <el-button type="primary" @click="updateDetails()">Modify</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      relevantInformationEntityList: [],
      biaoti: '',
      institutionName: '',
      detailsDialog: false,
      addDetailsDialog: false,
      updateDetailsDialog: false,
      relevantInformationId: '',
      relevantInformationTitle: '',
      relevantInformationContent: '',
      relevantInformationPicture: '',
      formLabelWidth: '120px',
      counselorid: this.$storage.get("counselorid"),

    };
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

    search() {
      this.$http.get('RelevantInformation/findRelevantInformation', {params: Object.assign({'biaoti' : this.biaoti})}).then(res => {
        this.relevantInformationEntityList = res.data.relevantInformationEntityList;
      });
    },

    openDetails(relevantInformationTitle, relevantInformationContent) {
      this.relevantInformationTitle = relevantInformationTitle;
      this.relevantInformationContent = relevantInformationContent;
      this.detailsDialog = true;
    },

    relevantInformationPictureUploadChange(fileUrls) {
      this.relevantInformationPicture = fileUrls;
    },

    openAddDetails() {
      this.relevantInformationTitle = '';
      this.relevantInformationContent = '';
      this.relevantInformationPicture = '';
      this.addDetailsDialog = true;
    },

    addDetails() {
      this.$http.get('RelevantInformation/addDetails', {params: Object.assign({'relevantInformationTitle' : this.relevantInformationTitle, 'relevantInformationContent' : this.relevantInformationContent, 'relevantInformationPicture' : this.relevantInformationPicture})}).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: res.data.message,
            type: 'success'
          });
          this.addDetailsDialog = false;
          this.getRelevantInformationEntityList();
        } else if (res.data.code == 400) {
          this.$message.error(res.data.message);
        }
      });
    },

    openUpdateDetails(relevantInformationId, relevantInformationPicture, relevantInformationTitle, relevantInformationContent) {
      this.relevantInformationId = relevantInformationId;
      this.relevantInformationPicture = relevantInformationPicture;
      this.relevantInformationTitle = relevantInformationTitle;
      this.relevantInformationContent = relevantInformationContent;
      this.updateDetailsDialog = true;
    },

    updateDetails() {
      this.$http.get('RelevantInformation/updateDetails', {params: Object.assign({'relevantInformationId' : this.relevantInformationId, 'relevantInformationTitle' : this.relevantInformationTitle, 'relevantInformationContent' : this.relevantInformationContent, 'relevantInformationPicture' : this.relevantInformationPicture})}).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: res.data.message,
            type: 'success'
          });
          this.updateDetailsDialog = false;
          this.getRelevantInformationEntityList();
        } else if (res.data.code == 400) {
          this.$message.error(res.data.message);
        }
      });
    },

    deleteDetails(relevantInformationId) {
      this.$confirm('This operation will permanently delete the relevant information, Do you want to continue?', 'prompt', {
        confirmButtonText: 'confirm',
        cancelButtonText: 'cancel',
        type: 'warning'
      }).then(() => {
        this.$http.get('RelevantInformation/deleteDetails', {params: Object.assign({'relevantInformationId' : relevantInformationId})}).then(res => {
          if (res.data.code == 200) {
            this.$message({
              message: res.data.message,
              type: 'success'
            });
            this.updateDetailsDialog = false;
            this.getRelevantInformationEntityList();
          } else if (res.data.code == 400) {
            this.$message.error(res.data.message);
          }
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Cancelled deletion'
        });
      });
    },

    // openUpdateScheduleDialog(applyforid, schedule) {
    //   this.applyforid = applyforid;
    //   this.schedule = schedule;
    //   this.detailsDialog = true;
    // },
    //
    // updateSchedule() {
    //   this.$http.get('institution/updateSchedule', {params: Object.assign({'applyforid' : this.applyforid, 'schedule' : this.schedule})}).then(res => {
    //     if (res.data.code == 200) {
    //       this.$message({
    //         message: res.data.message,
    //         type: 'success'
    //       });
    //       this.detailsDialog = false;
    //       this.findApplyForManageByCounselor();
    //     } else if (res.data.code == 400) {
    //       this.$message.error(res.data.message);
    //     }
    //   });
    // },
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

.relevantInformationContentClass {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
  text-overflow: ellipsis;
  font-size: 14px;
}
</style>