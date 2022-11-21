package com.ach.calendfi.conf;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
@Component
public class SshConfiguration implements ServletContextInitializer {

    public SshConfiguration() {
        try {
            Properties p = new Properties();
            InputStream input = SshConfiguration.class.getClassLoader().getResourceAsStream("application.properties");
            p.load(input);
            //If the configuration file contains the ssh.forward.enabled attribute, use ssh forwarding
            String enabled = p.getProperty("ssh.forward.enabled");
            if ("true".equals(enabled)) {
                log.info("ssh forward is opend.");
                log.info("ssh init ……");
                JSch jSch = new JSch();
                //Add when you need to use the secret key
                jSch.addIdentity(p.getProperty("ssh.identity"));
                Session session = jSch.getSession(p.getProperty("ssh.forward.username"), p.getProperty("ssh.forward.host"), Integer.parseInt(p.getProperty("ssh.forward.port")));
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(p.getProperty("ssh.forward.password"));
                session.connect();
                session.setPortForwardingL(p.getProperty("ssh.forward.from_host"), Integer.parseInt(p.getProperty("ssh.forward.from_port")), p.getProperty("ssh.forward.to_host"), Integer.parseInt(p.getProperty("ssh.forward.to_port")));
                session.setPortForwardingL(p.getProperty("ssh.forward.from_host"), Integer.parseInt(p.getProperty("ssh.forward.from_port_rd")), p.getProperty("ssh.forward.to_host_rd"), Integer.parseInt(p.getProperty("ssh.forward.to_port_rd")));
            } else {
                log.info("ssh forward is closed.");
            }
        } catch (IOException e) {
            log.error("ssh IOException failed.", e);
        } catch (JSchException e) {
            log.error("ssh JSchException failed.", e);
        } catch (Exception e) {
            log.error("ssh settings is failed. skip!", e);
        }
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Project started");
    }
}
