-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 服務器版本:                        10.2.8-MariaDB - mariadb.org binary distribution
-- 服務器操作系統:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 導出 security 的資料庫結構
DROP DATABASE IF EXISTS `security`;
CREATE DATABASE IF NOT EXISTS `security` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `security`;

-- 導出  表 security.user 結構
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_sid` char(36) NOT NULL COMMENT 'UUID',
  `name` varchar(20) NOT NULL COMMENT '名稱(帳號)',
  `password` varchar(20) NOT NULL COMMENT '密碼',
  `status` char(20) NOT NULL COMMENT '資料狀態',
  PRIMARY KEY (`user_sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='使用者';

-- 正在導出表  security.user 的資料：~0 rows (大約)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
