package com.babershopcarlosrosa.model.dto;

public class SchedulingDTO {
    
    private String daysToWork;
    private String namePlace;
    private String lastUpdate;

    //verificar se for tipo date
    private String workLoadInit;
    private String workLoadFinish;

    public SchedulingDTO(String daysToWork, String namePlace, String lastUpdate,
                        String workLoadInit, String workLoadFinish) {
            this.daysToWork = daysToWork;
            this.namePlace = namePlace;
            this.lastUpdate = lastUpdate;
            this.workLoadInit = workLoadInit;
            this.workLoadFinish = workLoadFinish;
    }

    public String getDaysToWork() {
		return daysToWork;
	}

	public void setDaysToWork(String daysToWork) {
		this.daysToWork = daysToWork;
	}

    public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

    public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

    public String getWorkLoadInit() {
		return workLoadInit;
	}

	public void setWorkLoadInit(String workLoadInit) {
		this.workLoadInit = workLoadInit;
	}

    public String getWorkLoadFinish() {
		return workLoadFinish;
	}

	public void setWorkLoadFinish(String workLoadFinish) {
		this.workLoadFinish = workLoadFinish;
	}

}
