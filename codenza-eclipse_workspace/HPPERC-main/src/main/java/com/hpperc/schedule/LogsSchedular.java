package com.hpperc.schedule;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AgeFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hpperc.utils.DateTimeMethodHelper;

@Service
@EnableScheduling
public class LogsSchedular {
	
	private static Logger logger=LogManager.getLogger(LogsSchedular.class);	
		
	@Scheduled(fixedRate = 60*60*1000)
	public void deleteOldFiles() throws ParseException {
		logger.info("Schedular running..");
	    Date oldestAllowedFileDate = DateTimeMethodHelper.minusDaysInDate(new Date(), 30); //minus days from current date
	    File targetDir = new File("mylogs/");
	    try {
			Iterator<File> filesToDelete = FileUtils.iterateFiles(targetDir, new AgeFileFilter(oldestAllowedFileDate), null);	   
			//if deleting subdirs, replace null above with TrueFileFilter.INSTANCE
			while (filesToDelete.hasNext()) {
			    FileUtils.deleteQuietly(filesToDelete.next());
			    logger.info("Log file deleted successfully.");
			}
		} catch (Exception e) {
			logger.warn("Error in log deletion."+e.getMessage());
		}  
	}
}
