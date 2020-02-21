package com.data.server

import com.data.server.download.Server
import com.jcraft.jsch._

class SFTPServer(url: String) extends Server {

  val session = null

  val host = "ftp.example.com"
  val port = 22

  def connect() {

    val jsch = new JSch();

    // Uncomment the line below if the FTP server requires certificate
    jsch.addIdentity("private-key-path");

    // Uncomment the two lines below if the FTP server requires password
    session = jsch.getSession("username", host)

    session.setPassword("the-password")
    session.setConfig("StrictHostKeyChecking", "no")
    session.connect();
  }

  public void upload(String source, String destination) throws JSchException, SftpException {
    Channel channel = session.openChannel("sftp");
    channel.connect();
    ChannelSftp sftpChannel = (ChannelSftp) channel;
    sftpChannel.put(source, destination);
    sftpChannel.exit();
  }

  @throws[JSchException]
  @throws[SftpException]
  def download: Unit = {
    val channel = session.openChannel("sftp")
    channel.connect
    val sftpChannel = channel.asInstanceOf[Nothing]
    sftpChannel.get(source, destination)
    sftpChannel.exit
  }

  def disconnect(): Unit = {
    if (session != null) session.disconnect
  }

}
