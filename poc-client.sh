#!/bin/bash

REST_USER=macgyver
REST_PASSWORD=jboss

usage() {
	echo ''
	echo 'VALID OPTIONS:'
	echo '=================
	"add-roles <EAP_PATH>" -- Add example users/roles to EAP and BPMS (WARNING: THIS WILL OVERWRITE EXISTING USERS/ROLES)
	"install" -- Clone the GitHub repository into BPMS
	"usage" -- See this dialog again
	"signal <PERMIT_ID> <SIGNAL>" -- Send SIGNAL to the process identified by PERMIT_ID'
	echo ''
	echo 'VALID SIGNALS:'
	echo '=================
	"approve" -- Sets the status to APPROVED
	"deny" -- Sets the status to DENIED
	"reset" -- Sets the status to IN_PROGRESS'
	echo ''
}

add-roles() {
	echo '--- Overwriting users and roles in $1/domain/configuration ---'
	cp config/domain/configuration/{application-*,mgmt-*} $1/domain/configuration/
	echo ''
	echo '--- Overwriting users and roles in $1/standalone/configuration ---'
	cp config/standalone/configuration/{application-*,mgmt-*} $1/standalone/configuration/
	echo ''
	echo '--- Script complete! ---'
}

install() {
	echo '--- Creating Organizational Unit "solar-village" in BPMS ---'
	curl -X POST 'localhost:8080/business-central/rest/organizationalunits/' -u ${REST_USER}:${REST_PASSWORD} -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"name":"solar-village","description":null,"owner":"macgyver","repositories":null}'
	sleep 3
	echo ''
	echo '--- Downloading GitHub repository and cloning it into "solar-village" OU ---'
	curl -X POST 'localhost:8080/business-central/rest/repositories/' -u ${REST_USER}:${REST_PASSWORD} -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"name":"SolarVillage","description":null,"requestType":"clone","gitURL":"https://github.com/seii/SolarVillageBPMS.git","organizationalUnitName":"solar-village"}'
#	echo ''
#	echo '--- Compiling and installing "SolarVillage" project within BPMS ---'
#	curl -X POST 'localhost:8080/business-central/rest/repositories/solar-village/projects/SolarVillage/maven/install/' -u ${REST_USER}:${REST_PASSWORD} -H 'Accept: application/json'
#	echo ''
#	echo '--- Deploying process definitions within BPMS ---'
#	curl -X POST 'localhost:8080/business-central/rest/deployment/com.solarvillage:SolarVillage:1.1/deploy' -u ${REST_USER}:${REST_PASSWORD}
	echo ''
	echo '--- Script complete! ---'
}

signal() {
	echo '--- Signalling process ---'
	curl -X POST 'http://localhost:8080/bpmspoc/rest/query/signal/electrical/$1/$2' -u ${REST_USER}:${REST_PASSWORD} -H 'Accept: application/json'
}

case "$1" in
    install)
        install
        ;;
    add-roles)
	add-roles $2
	;;
    signal)
	signal $2 $3
	;;
#    stop)
#        stopHosts $2
#        ;;
#    restart)
#        stopHosts && startHosts
#        ;;
#    status)
#        if [ -n "$2" ]
#        then
#                statusOneHost $2
#        else
#                statusHosts
#        fi
#        ;;
#    snapshot)
#        snapshotHosts
#        ;;
#    snapshot-list)
#        snapshotList
#        ;;
#    revert)
#        revertHosts
#        ;;
#    delete-snapshots)
#        deleteSnapshots
#        ;;
    *)
        usage
        ;;
esac

