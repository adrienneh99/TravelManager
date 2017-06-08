package domain;

/**
 * @author adrienne2
 *
 */
public class TravelManagerError {
	
	/**
	 * 
	 */
	private String title;
	
	/**
	 * 
	 */
	private String message;
	
	/**
	 * 
	 */
	private String lastPage;
	
	/**
    * Default constructor
    */
	public TravelManagerError() {
	}
	
	/**
	 * @param title
	 * @param message
	 */
	public TravelManagerError(String title, String message) {
		this.title = title;
		this.message = message;
	}
	
	/**
	 * @param title
	 * @param message
	 * @param lastPage 
	 */
	public TravelManagerError(String title, String message, String lastPage) {
		this.title = title;
		this.message = message;
		this.lastPage = lastPage;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the lastPage
	 */
	public String getLastPage() {
		return lastPage;
	}


	/**
	 * @param lastPage the lastPage to set
	 */
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastPage == null) ? 0 : lastPage.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TravelManagerError other = (TravelManagerError) obj;
		if (lastPage == null) {
			if (other.lastPage != null) {
				return false;
			}
		} else if (!lastPage.equals(other.lastPage)) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
}
