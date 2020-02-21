package com.data.server.configuration

import com.typesafe.config.{Config, ConfigFactory}

class DataDownloadGlobalConfiguration(config: Config) extends Serializable {
  val input: Config = config.getConfig("input")
  val filePathList = input.getStringList("path")

}


object DataDownloadGlobalConfiguration {
  def apply(source: String): DataDownloadGlobalConfiguration = {
    val analyticsConfig = ConfigFactory.load(source)
    new DataDownloadGlobalConfiguration(analyticsConfig)
  }
}
