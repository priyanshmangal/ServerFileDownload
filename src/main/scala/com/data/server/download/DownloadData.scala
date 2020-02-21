package com.data.server.download

import com.data.server.configuration.DataDownloadGlobalConfiguration

object DownloadData {

  def main(args: Array[String]): Unit = {


    val dataDownloadConfiguration = DataDownloadGlobalConfiguration("analytics")

    val fileDownloadUrlList = dataDownloadConfiguration.filePathList

    fileDownloadUrlList.forEach{ case fileURL =>
        Server(fileURL).downloadData

    }


  }

}
