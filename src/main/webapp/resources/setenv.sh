export logback_logs_path=$CATALINA_HOME/logs

export CATALINA_OPTS="$CATALINA_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n"