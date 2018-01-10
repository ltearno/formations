<?php

try {
    $responseBody = file_get_contents('http://store-service.default.svc.cluster.local');
    $storeInfo = json_decode($responseBody, true);
    $storeInfo["backend-pod"] = gethostname();
    echo json_encode($storeInfo);
} catch (Exception $ex) {
    echo json_encode(array("message"=>"error !"));
}

?>