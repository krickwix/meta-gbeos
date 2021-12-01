
SUMMARY = "Python parsing module"
HOMEPAGE = "https://github.com/pyparsing/pyparsing/"
AUTHOR = "Paul McGuire <ptmcg.gm+pyparsing@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=657a566233888513e1f07ba13e2f47f1"

SRC_URI = "https://files.pythonhosted.org/packages/ab/61/1a1613e3dcca483a7aa9d446cb4614e6425eb853b90db131c305bd9674cb/pyparsing-3.0.6.tar.gz"
SRC_URI[md5sum] = "2f5fad6c8e99ac2562ab08ad9e45b195"
SRC_URI[sha256sum] = "d9bdec0013ef1eb5a84ab39a3b3868911598afa494f5faa038647101504e2b81"

S = "${WORKDIR}/pyparsing-3.0.6"

RDEPENDS_${PN} = ""

inherit setuptools3
