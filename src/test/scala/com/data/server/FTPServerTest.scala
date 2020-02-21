package com.data.server

import org.joda.time.DateTime
import org.scalatest.FunSuite

class FTPServerTest extends FunSuite {


  test("FTPServerTest") {

    new FTPServer("https://file/abc.txt").downloadData

  }

  test("FTPServerTest - Stream Check") {
    import java.net.ServerSocket;

    val server = new ServerSocket(8080)
    val socket = server.accept
    val today = new DateTime()
    val httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today
    socket.getOutputStream.write(httpResponse.getBytes("UTF-8"))
  }


}
