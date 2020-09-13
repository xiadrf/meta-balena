DESCRIPTION = "This minimal image is executed by a vendor provided bootloader. \
It contains all the BalenaOS bootloader specific features, and will kexec the \
BalenaOS initramfs"

PACKAGE_INSTALL = " \
    kexecboot \
    kexec-tools-klibc \
"

# Allow for image debugging in development image
PACKAGE_INSTALL_append = " ${@bb.utils.contains('DEVELOPMENT_IMAGE','1','initramfs-debug busybox base-passwd ${ROOTFS_BOOTSTRAP_INSTALL}','',d)}"
BAD_RECOMMENDATIONS += "${@bb.utils.contains('DEVELOPMENT_IMAGE','1','busybox-syslog','',d)}"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "balena-image-boot-initramfs"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit image

IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
