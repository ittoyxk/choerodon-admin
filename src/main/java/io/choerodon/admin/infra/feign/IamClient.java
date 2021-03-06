package io.choerodon.admin.infra.feign;


import io.choerodon.admin.api.dto.Menu;
import io.choerodon.admin.infra.feign.fallback.IamClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * iam service feign client
 * @author superlee
 * @since 2019-06-11
 */
@FeignClient(value = "choerodon-iam", fallback = IamClientFallback.class)
public interface IamClient {

    @GetMapping(value = "/choerodon/v1/menus/flat")
    ResponseEntity<List<Menu>> listMenuByLabel(@RequestParam(required = false,value = "labels") Set<String> labels);

    @PutMapping(value = "/choerodon/v1/permission/role_permission_async")
    ResponseEntity<Void> asyncRolePermision();

}
