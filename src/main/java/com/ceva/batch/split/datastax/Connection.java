package com.ceva.batch.split.datastax;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.mapping.MappingManager;

/**
 * Cassandra connection.
 * 
 * @author rajesh.
 *
 */
public class Connection {
  
  private  Cluster cluster;
  private  Session session;
  private MappingManager manager;

  @Value("${cassandra.username}")
  private String username;

  @Value("${cassandra.password}")
  private String password;

  @Value("${cassandra.contact-points}")
  private String contactpoints;
  @Value("${cassandra.keyspace-name}")
  private String keyspace;

   public Cluster getCluster() {
    return cluster;
  }


  public void setCluster(Cluster cluster) {
    this.cluster = cluster;
  }


  public Session getSession() {
    return session;
  }


  public void setSession(Session session) {
    this.session = session;
  }


  public MappingManager getManager() {
    return manager;
  }


  public void setManager(MappingManager manager) {
    this.manager = manager;
  }

  /**
   * initialization.
   */
  @PostConstruct
  private void init() {
    AuthProvider authprovider = new PlainTextAuthProvider(username,password);
    SocketOptions socketOptions =
        new SocketOptions().setConnectTimeoutMillis(2000000).setReadTimeoutMillis(1000000);
    cluster = Cluster.builder().withClusterName(keyspace).addContactPoints(contactpoints)
        .withAuthProvider(authprovider).withSocketOptions(socketOptions).withoutJMXReporting()
        .build();
    session = cluster.connect(keyspace);
    MappingManager manager = new MappingManager(session);
    this.setManager(manager);
  }
}
