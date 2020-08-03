HOMEPAGE = "https://www.balena.io/"
SUMMARY = "Utility to mount container filesystems"
DESCRIPTION = "Utility to mount container filesystems"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit go

RDEPENDS_${PN} = "util-linux"

GO_IMPORT = "github.com/balena-os/hostapp"
SRC_URI = "git://${GO_IMPORT};nobranch=1"
SRCREV="524448ff27c5e76ee56e39f58b77667127d799c9"

do_compile() {
    cd ${S}/src/${GO_IMPORT}
    unset GOPATH GOROOT
    oe_runmake
}

do_install() {
	install -d ${D}/boot
        install -m 0755 ${S}/src/${GO_IMPORT}/mobynit ${D}/boot/init
}

FILES_${PN} += " \
    /boot/init \
"
