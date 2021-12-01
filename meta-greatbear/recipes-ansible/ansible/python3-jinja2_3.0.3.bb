
SUMMARY = "A very fast and expressive template engine."
HOMEPAGE = "https://palletsprojects.com/p/jinja/"
AUTHOR = "Armin Ronacher <armin.ronacher@active-4.com>"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=5dc88300786f1c214c1e9827a5229462"

SRC_URI = "https://files.pythonhosted.org/packages/91/a5/429efc6246119e1e3fbf562c00187d04e83e54619249eb732bb423efa6c6/Jinja2-3.0.3.tar.gz"
SRC_URI[md5sum] = "b76ae2f0647abebc81e7c03f5fb7b00f"
SRC_URI[sha256sum] = "611bb273cd68f3b993fabdc4064fc858c5b47a973cb5aa7999ec1ba405c87cd7"

S = "${WORKDIR}/Jinja2-3.0.3"

RDEPENDS_${PN} = "python3-markupsafe"

inherit setuptools3
