
SUMMARY = "Core utilities for Python packages"
HOMEPAGE = "https://github.com/pypa/packaging"
AUTHOR = "Donald Stufft and individual contributors <donald@stufft.io>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=faadaedca9251a90b205c9167578ce91"

SRC_URI = "https://files.pythonhosted.org/packages/df/9e/d1a7217f69310c1db8fdf8ab396229f55a699ce34a203691794c5d1cad0c/packaging-21.3.tar.gz"
SRC_URI[md5sum] = "e713c1939f294fd729af4a7be40dd141"
SRC_URI[sha256sum] = "dd47c42927d89ab911e606518907cc2d3a1f38bbd026385970643f9c5b8ecfeb"

S = "${WORKDIR}/packaging-21.3"

RDEPENDS_${PN} = "python3-pyparsing"

inherit setuptools3
