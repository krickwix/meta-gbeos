
SUMMARY = "Radically simple IT automation"
HOMEPAGE = "https://ansible.com/"
AUTHOR = "Ansible, Inc. <info@ansible.com>"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI = "https://files.pythonhosted.org/packages/be/1a/f40e97f4c400eec75813bc492f1d6226cd413bf03f88d5f00070a1e699a3/ansible-core-2.11.6.tar.gz"
SRC_URI[md5sum] = "59ffdc26466b8f14c91502f876afd3c8"
SRC_URI[sha256sum] = "93d50283c7c5b476debf83dc089b3f679b939a8b9a7b5d628d28daafbb3d303a"

S = "${WORKDIR}/ansible-core-2.11.6"

RDEPENDS_${PN} = ""

inherit setuptools3
