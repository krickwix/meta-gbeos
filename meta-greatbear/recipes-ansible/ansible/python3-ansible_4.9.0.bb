
SUMMARY = "Radically simple IT automation"
HOMEPAGE = "https://ansible.com/"
AUTHOR = "Ansible, Inc. <info@ansible.com>"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI = "https://files.pythonhosted.org/packages/6c/6a/d2729c854d5487f4c8e18a72eadf53287a2aa16d7924df39751025592ab9/ansible-4.9.0.tar.gz"
SRC_URI[md5sum] = "fd266d0d6d5c58ae644e26552182c937"
SRC_URI[sha256sum] = "e8768deafd08da710de4aee518ec7f84d270faf64a9e71e63239b23c14806ba7"

S = "${WORKDIR}/ansible-4.9.0"

RDEPENDS_${PN} = "\
	python3-ansible-core \
	python3-cffi \
	python3-cryptography \
	python3-jinja2 \
	python3-markupsafe \
	python3-packaging \
	python3-pycparser \
	python3-pyparsing \
	python3-pyyaml \
	python3-resolvelib \
	bash \
"

inherit setuptools3
