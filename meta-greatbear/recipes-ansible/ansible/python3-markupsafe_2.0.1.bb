
SUMMARY = "Safely add untrusted strings to HTML/XML markup."
HOMEPAGE = "https://palletsprojects.com/p/markupsafe/"
AUTHOR = "Armin Ronacher <armin.ronacher@active-4.com>"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=ffeffa59c90c9c4a033c7574f8f3fb75"

SRC_URI = "https://files.pythonhosted.org/packages/bf/10/ff66fea6d1788c458663a84d88787bae15d45daa16f6b3ef33322a51fc7e/MarkupSafe-2.0.1.tar.gz"
SRC_URI[md5sum] = "892e0fefa3c488387e5cc0cad2daa523"
SRC_URI[sha256sum] = "594c67807fb16238b30c44bdf74f36c02cdf22d1c8cda91ef8a0ed8dabf5620a"

S = "${WORKDIR}/MarkupSafe-2.0.1"

RDEPENDS_${PN} = ""

inherit setuptools3
