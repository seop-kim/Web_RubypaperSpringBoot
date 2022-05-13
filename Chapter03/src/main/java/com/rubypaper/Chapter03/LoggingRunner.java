package com.rubypaper.Chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.trace("TRACE Log Msg");
        logger.debug("DEBUG Log Msg");
        logger.info("INFO Log Msg");
        logger.warn("WARN Log Msg");
        logger.error("ERROR Log Msg");
    }
}
