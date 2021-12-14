require conf/distro/poky.conf

DISTRO = "gbeos-base"
DISTRO_NAME = "GreatBear Distro Base"
DISTRO_VERSION = "3.4-snapshot-${DATE}"

DISTRO_FEATURES_append = "wifi virtualization systemd python seccomp k3s"

IMAGE_INSTALL_append = "linux-firmware kernel-modules wpa-supplicant bash parted e2fsprogs e2fsprogs-resize2fs k3s dpkg glibc-utils python3 python3-pip curl "
IMAGE_INSTALL_append = "python3-ansible python3-ansible-core python3-cffi python3-cryptography python3-jinja2 python3-markupsafe python3-packaging python3-pycparser python3-pyparsing python3-pyyaml python3-resolvelib"

DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"



CMDLINE_ROOTFS ?= "root=/dev/mmcblk0p2 rootfstype=ext4 rootwait cgroup_memory=1 cgroup_enable=memory"
