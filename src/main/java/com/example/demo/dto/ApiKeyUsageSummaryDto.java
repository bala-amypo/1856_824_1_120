package com.example.demo.dto;

public class ApiKeyUsageSummaryDto {

    private Long apiKeyId;
    private Long totalRequestsToday;

    public ApiKeyUsageSummaryDto() {
    }

    public ApiKeyUsageSummaryDto(Long apiKeyId, Long totalRequestsToday) {
        this.apiKeyId = apiKeyId;
        this.totalRequestsToday = totalRequestsToday;
    }

    public Long getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(Long apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public Long getTotalRequestsToday() {
        return totalRequestsToday;
    }

    public void setTotalRequestsToday(Long totalRequestsToday) {
        this.totalRequestsToday = totalRequestsToday;
    }
}
