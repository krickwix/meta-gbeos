
SUMMARY = "Resolve abstract dependencies into concrete ones"
HOMEPAGE = "https://github.com/sarugaku/resolvelib"
AUTHOR = "Tzu-ping Chung <uranusjr@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78e1c0248051c32a38a7f820c30bd7a5"

SRC_URI = "https://files.pythonhosted.org/packages/8f/7f/b8b2c7e8b2030710b6ef2d14b2201272dfe437d6c37cec29c60f38d3139d/resolvelib-0.5.4.tar.gz"
SRC_URI[md5sum] = "98078e0fcd9366278f64af522cd124fa"
SRC_URI[sha256sum] = "9b9b80d5c60e4c2a8b7fbf0712c3449dc01d74e215632e5199850c9eca687628"

S = "${WORKDIR}/resolvelib-0.5.4"

RDEPENDS_${PN} = ""

inherit setuptools3
