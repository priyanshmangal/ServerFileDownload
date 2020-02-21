package com.data.server

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

import com.data.server.download.Server
import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient

class FTPServer(url: String) extends Server {


  val server = "www.myserver.com"
  val port = 21
  val user = "user"
  val pass = "pass"

  override def downloadData : Unit = {
    val ftpClient = new FTPClient

    try {
      ftpClient.connect(server, port)
      ftpClient.login(user, pass)
      ftpClient.enterLocalPassiveMode
      ftpClient.setFileType(FTP.BINARY_FILE_TYPE)
      // APPROACH #1: using retrieveFile(String, OutputStream)
      val remoteFile1 = "/test/video.mp4"
      val downloadFile1 = new File("D:/Downloads/video.mp4")
      val outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1))
      var success = ftpClient.retrieveFile(remoteFile1, outputStream1)
      outputStream1.close()
      if (success) System.out.println("File #1 has been downloaded successfully.")
      // APPROACH #2: using InputStream retrieveFileStream(String)
      val remoteFile2 = "/test/song.mp3"
      val downloadFile2 = new File("D:/Downloads/song.mp3")
      val outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2))
      val inputStream = ftpClient.retrieveFileStream(remoteFile2)
      val bytesArray = new Array[Byte](4096)
      var bytesRead = -1
      while ( {
        (bytesRead = inputStream.read(bytesArray)) != -1
      }) outputStream2.write(bytesArray, 0, bytesRead)
      success = ftpClient.completePendingCommand
      if (success) System.out.println("File #2 has been downloaded successfully.")
      outputStream2.close()
      inputStream.close
    } catch {
      case ex: IOException =>
        System.out.println("Error: " + ex.getMessage)
        ex.printStackTrace()
    } finally try if (ftpClient.isConnected) {
      ftpClient.logout
      ftpClient.disconnect
    }
    catch {
      case ex: IOException =>
        ex.printStackTrace()
    }
  }

}
