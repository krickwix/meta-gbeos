
SUMMARY = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
AUTHOR = "The Python Cryptographic Authority and individual contributors <cryptography-dev@python.org>"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba"

SRC_URI = "https://files.pythonhosted.org/packages/60/06/d9109aba62c0b42466195e5b9b30dded26621a675b73998218070d8cc637/cryptography-36.0.0.tar.gz"
SRC_URI[md5sum] = "b01bc982e1f978a0536f1651a0db9d36"
SRC_URI[sha256sum] = "52f769ecb4ef39865719aedc67b4b7eae167bafa48dbc2a26dd36fa56460507f"

S = "${WORKDIR}/cryptography-36.0.0"

RDEPENDS_${PN} = "python3-cffi"

inherit setuptools3
