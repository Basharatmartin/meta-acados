# ACADOS - Recipe for yocto compiled image of Raspberrypi - 4 64bit image
# Created: Basharat Martin
# Date: 04.03.2020
#

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7faa27919608de118a0bf9352683235d"

PV = "1.0"
PR = "r0"

SRCREV = "35288465716ec7abc538909d77e98dd1e0b70374"

SRC_URI = "git://github.com/acados/acados.git;branch=master"

S = "${WORKDIR}/git"

#RDEPENDS_acados ?= ""


#inherit cmake
OECMAKE_GENERATOR = "Unix Makefiles"

#EXTRA_OECMAKE = ""


#INSANE_SKIP_${PN} = "already-stripped"
#do_unpack[noexec] = "1"


do_configure_prepend() {

	cd ${WORKDIR}/git
	git submodule update --recursive --init 
	rm -rf build
	rm -rf ../../acados-installed
	mkdir build
	mkdir -p ../../acados-installed
}

do_configure() {

	cd ${S}/build
	cmake .. -DACADOS_WITH_QPOASES=ON -DACADOS_PYTHON=ON -DACADOS_INSTALL_DIR=${S}/../../acados-installed
	make install
}


##do_install () {
##
##
##}

##FILES_${PN} += " \
##		${prefix}/local/runtime/	\
##		${prefix}/local/runtime_backup	\
##		"
##
