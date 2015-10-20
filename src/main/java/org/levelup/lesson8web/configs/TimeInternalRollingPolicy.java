package org.levelup.lesson8web.configs;

import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by proton on 07.07.2015.
 */
public class TimeInternalRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String logPath;

    public TimeInternalRollingPolicy() {
        logPath = System.getenv("logback_logs_path");
        logger.info("logs_path: ", logPath);
        setMaxHistory(Integer.MAX_VALUE);
    }

    /**
     * Make path where logs should be saved. If path not containing in system properties, return default value
     *
     * @return log path
     */
    public String getLogPath() {
        if (logPath == null || logPath.isEmpty()) {
            return getDefaultLogPath();
        }
        return logPath;
    }

    /**
     * Make default log path
     *
     * @return log path
     */
    public String getDefaultLogPath() {
        return String.format("%s%5$s%s%5$s%s%5$s%s", System.getProperty("user.home"), "tmp", "tomcat", "logs",
                File.separator);
    }

    /**
     * Setting log file pattern
     *
     * @param fileNamePattern contain log file name pattern
     */
    @Override
    public void setFileNamePattern(String fileNamePattern) {
        String filePattern = String.format("%s%s%s", getLogPath(), File.separator, fileNamePattern);
        logger.debug("{} [setFileNamePattern]: filePattern: {}", getClass().getName(), filePattern);
        super.setFileNamePattern(filePattern);
    }
}

