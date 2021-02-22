package com.webexapis.v1.broadWorksSubscribers.broadWorksSubscribersRequests;

public class POJOBroadWorksSubscribersRequests {

    private POJOGetListBroadWorksSubscribersQueryParam POJOGetListQP;

    public POJOBroadWorksSubscribersRequests(String subscriberId) {
        // (в конструкторе создается объект POJOGetListBroadWorksSubscribersQueryParam)
        this.POJOGetListQP = new POJOGetListBroadWorksSubscribersQueryParam(subscriberId);


    }

}
    // subclasses are needed for various query params of API requests

    class POJOGetListBroadWorksSubscribersQueryParam{

        private String subscriberId;

        public POJOGetListBroadWorksSubscribersQueryParam(String subscriberId) {
            this.subscriberId = subscriberId;
        }

        public void setSubscriberId(String subscriberId) {
            this.subscriberId = subscriberId;
        }

    }
/*
        private String userID, personID, email, provisioningId, spEnterpriseId, lastStatusChange, status, after;

        private boolean selfActivated;

        private int max;

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public void setPersonID(String personID) {
            this.personID = personID;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setProvisioningId(String provisioningId) {
            this.provisioningId = provisioningId;
        }

        public void setSpEnterpriseId(String spEnterpriseId) {
            this.spEnterpriseId = spEnterpriseId;
        }

        public void setLastStatusChange(String lastStatusChange) {
            this.lastStatusChange = lastStatusChange;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setAfter(String after) {
            this.after = after;
        }

        public void setSelfActivated(boolean selfActivated) {
            this.selfActivated = selfActivated;
        }

        public void setMax(int max) {
            this.max = max;
        }*/
