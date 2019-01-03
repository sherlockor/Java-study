package log;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class TestLog {
	public TestLog() throws InterruptedException {
		Logger logger = Logger.getLogger(TestLog.class);
		PropertyConfigurator.configure("E:\\MyCode\\Java\\J2SE\\src\\log\\log.properties");
		logger.setLevel(Level.DEBUG);
		logger.trace("跟踪信息");
		logger.debug("调试信息");
		logger.info("输出信息");
		Thread.sleep(1000);
		logger.warn("警告信息");
		logger.error("错误信息");
		logger.fatal("致命信息");
	}
}
