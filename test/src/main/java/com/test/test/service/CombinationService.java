package com.test.test.service;

import java.util.Map;

public interface CombinationService {
    public String insertSetting(Map<String, String> map);

    public String deleteSetting(Map<String, String> map);

    public String insertDownload(Map<String, String> map);

    public String deleteDownload(Map<String, String> map);

    public String insertComment(Map<String, String> map);

    public String deleteComment(Map<String, String> map);
}
