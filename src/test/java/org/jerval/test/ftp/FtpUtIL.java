package org.jerval.test.ftp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.net.SyslogAppender;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FtpUtIL {

	private String host="192.168.93.131";
	private int port=22;
	private String username="root";
	private String password="qgqg2512";
	private ChannelSftp sftp = null;
    public ChannelSftp getSftp() {
		return sftp;
	}

	public void setSftp(ChannelSftp sftp) {
		this.sftp = sftp;
	}

	private Session sshSession = null;
	
	public void inti() throws JSchException {
		JSch jsch = new JSch();
		sshSession = jsch.getSession(username, host, port);
		  sshSession.setPassword(password);
          Properties sshConfig = new Properties();
          sshConfig.put("StrictHostKeyChecking", "no");
          sshSession.setConfig(sshConfig);
          sshSession.connect();
          System.out.println("ssh连接。。。");
          sftp = (ChannelSftp) sshSession.openChannel("sftp");
          sftp.connect();
          System.out.println("ftp连接。。。。");
	}

	
	
	
	public void closeSession() {
		if(sshSession!=null) {
			sshSession.disconnect();
		}
	}

	private void closeSftp() {
		if(sftp!=null) {
			sftp.disconnect();
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws JSchException, SftpException, IOException {
		FtpUtIL ftpUtIL = new FtpUtIL();
		ftpUtIL.inti();
		String dir="/root/user/wxq/images/";
		ChannelSftp sftp2 = ftpUtIL.getSftp();
		sftp2.cd(dir);
		Vector<?> ls = sftp2.ls(dir);
		ls.forEach((e)->System.out.println(((LsEntry)e).getFilename()));
		sftp2.put("3.jpg","222.jpg");
		InputStream inputStream = sftp2.get(dir+"1.jpg");
		FileOutputStream fos = new FileOutputStream("1.jpg");
		byte[] data=new byte[1024*8];
		int len=0;
		while((len=inputStream.read(data))!=-1) {
			fos.write(data, 0, len);
		}
		fos.close();
		inputStream.close();
		ftpUtIL.closeSftp();
		ftpUtIL.closeSession();
	}
	
	
}
