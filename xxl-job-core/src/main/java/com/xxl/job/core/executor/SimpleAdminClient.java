package com.xxl.job.core.executor;

import com.xxl.job.core.biz.AdminBiz;
import com.xxl.job.core.biz.client.AdminBizClient;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdminClient implements AdminClient {

    private  final List<AdminBiz> adminBizList = new ArrayList<>();



    public SimpleAdminClient(String adminAddresses, String accessToken, AdminClient adminClient) {
        this(adminAddresses,accessToken);
        if (adminClient != null) {
            this.adminBizList.addAll(adminClient.getAdminBizs());
        }
    }


    public SimpleAdminClient(String adminAddresses, String accessToken ) {
        if (adminAddresses!=null && adminAddresses.trim().length()>0) {
            for (String address: adminAddresses.trim().split(",")) {
                if (address!=null && address.trim().length()>0) {
                    AdminBiz adminBiz = new AdminBizClient(address.trim(), accessToken);
                    adminBizList.add(adminBiz);
                }
            }
        }
    }

    @Override
    public List<AdminBiz> getAdminBizs() {
        return adminBizList;
    }
}
