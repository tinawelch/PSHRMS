package com.footlocker.common.document;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.footlocker.common.Builder;
import com.footlocker.common.user.User;
import com.footlocker.common.util.DateTimeUtil;

public class FinancialReport extends AbstractLoggableDocument {

	private FinancialReport(ReportBuilder builder) {
		super(builder.fileName, builder.lastModified, builder.dateCreated, builder.userAccessLog);	
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof FinancialReport)) 
			return false;
		
		FinancialReport rep = (FinancialReport)o;
		return rep.getFileName().equals(this.getFileName())
				&& rep.getLastModified().equals(this.getLastModified())
				&& rep.getDateCreated().equals(this.getDateCreated())
				&& rep.getUserAccessLog().equals(this.getUserAccessLog());
	}

	
	public static class ReportBuilder implements Builder<FinancialReport> {
		//Required parameters
		private final String fileName;
		
		//Optional values
		private ZonedDateTime lastModified;
		private ZonedDateTime dateCreated;
		private Map<User, List<ZonedDateTime>> userAccessLog = new HashMap<User, List<ZonedDateTime>>();
		
		public ReportBuilder(String fileName) {
			this.fileName = fileName;
			
			ZonedDateTime currentTime = DateTimeUtil.currentGMT();
			lastModified = currentTime;
			dateCreated = currentTime;		
		}
		
		public ReportBuilder lastModified(ZonedDateTime lastModified) {
			this.lastModified = lastModified;
			return this;
		}
		
		public ReportBuilder dateCreated(ZonedDateTime dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}
		
		public ReportBuilder userAccessLog(Map<User, List<ZonedDateTime>> userAccessLog) {
			this.userAccessLog = userAccessLog;
			return this;
		}
		
		@Override
		public FinancialReport build() {
			return new FinancialReport(this);
		}
	}


}
