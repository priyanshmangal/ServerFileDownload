package com.data.server.download

import com.data.server.{FTPServer, SFTPServer}

trait Server {

  def downloadData : Unit

}


object Server {

  /** Factory Method for Definition Transformer
   *
   * We return instances of QualityDefinitionTransformer, VisitDefinitionTransformer, etc based on measureCategory.
   */
  def apply(url: String): Server = {

    url.toLowerCase match {
      case _ if url.startsWith("http") => new HTTPServer(url: String)
      case _ if url.startsWith("ftp") => new FTPServer(url: String)
      case _ if url.startsWith("sftp") => new SFTPServer(url: String)
      case _ =>
        throw new IllegalArgumentException(s"url : $url - does not support server type")
    }
  }
}
