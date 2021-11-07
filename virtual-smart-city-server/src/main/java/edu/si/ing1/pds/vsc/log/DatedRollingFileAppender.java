/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.si.ing1.pds.vsc.log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author aggoun.abdelkrim
 *
 */
public class DatedRollingFileAppender extends FileAppender {

    /**
     * Datepattern
     */
    private String datePattern = "yyyy-MM-dd";

    /**
     * Date in use for the actual logs file
     */
    private String dateFileInUse = null;

    /**
     * The file pattern name
     */
    private String logFileName = "%date%_logs.log";

    public DatedRollingFileAppender() {
    }

    public String getDatePattern() {
        return datePattern;
    }

    /**
     *
     * @param datePattern
     */
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    /**
     * Return the file pattern.
     *
     * @return
     */
    @Override
    public String getFile() {
        return logFileName;
    }

    /**
     * Set the file paterne name. %date% will be replace with the current date
     *
     * @param fileName
     */
    @Override
    public void setFile(String fileName) {
        logFileName = fileName;
        makeNewFileLog();
    }

    /**
     *
     * @param event
     */
    @Override
    public void append(LoggingEvent event) {
        if (this.layout == null) {
            errorHandler.error("No layout set for the appender named [" + name + "].");
            return;
        }
        // va creer ou non un nouveau fichier de log
        makeNewFileLog();
        if (this.qw == null) { // should never happen
            errorHandler.error("No output stream or file set for the appender named [" + name + "].");
            return;
        }
        subAppend(event);
    }

    /**
     * Va creer ou non un nouveau fichier de log
     */
    private void makeNewFileLog() {
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        String strDate = sdf.format(new Date());
        // si la date en cours d'utilisation est differente de l'actuelle (toujours en fonction du pattern)
        if ((dateFileInUse == null) || (dateFileInUse != null && !dateFileInUse.equalsIgnoreCase(strDate))) {
            if (datePattern != null && logFileName != null) {
                dateFileInUse = strDate;
                fileName = logFileName.replaceAll("%date%", strDate);
                super.activateOptions(); // close current file and open new file
            } else {
                System.err.println("Either File or DatePattern options are not set for appender [" + name + "].");
            }
        } else // dans le cas où le fichier aurait ete supprime
        {
            if (!(new File(this.getFile())).exists()) {
                dateFileInUse = null;
                makeNewFileLog();
            }
        }
    }

}
