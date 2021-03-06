USE [master]
GO
/****** Object:  Database [Car]    Script Date: 8/24/2021 11:16:45 AM ******/
CREATE DATABASE [Car]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Test', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Test.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Test_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Test_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Car] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Car].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Car] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Car] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Car] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Car] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Car] SET ARITHABORT OFF 
GO
ALTER DATABASE [Car] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Car] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Car] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Car] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Car] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Car] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Car] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Car] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Car] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Car] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Car] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Car] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Car] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Car] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Car] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Car] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Car] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Car] SET RECOVERY FULL 
GO
ALTER DATABASE [Car] SET  MULTI_USER 
GO
ALTER DATABASE [Car] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Car] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Car] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Car] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Car] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Car] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Car', N'ON'
GO
ALTER DATABASE [Car] SET QUERY_STORE = OFF
GO
USE [Car]
GO
/****** Object:  Table [dbo].[account]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](100) NULL,
	[password] [nvarchar](50) NULL,
	[displayName] [nvarchar](100) NULL,
	[address] [nvarchar](200) NULL,
	[phone] [nvarchar](30) NULL,
	[roll_id] [int] NULL,
	[status] [int] NULL,
	[create_date] [date] NULL,
 CONSTRAINT [PK__account__CB9A1CFF5AAE8804] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Car]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car](
	[carID] [int] IDENTITY(1,1) NOT NULL,
	[category_id] [int] NULL,
	[car_name] [nvarchar](200) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
	[description] [nvarchar](2000) NULL,
	[color] [nvarchar](50) NULL,
	[image] [nvarchar](100) NULL,
	[create_date] [date] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK__Book__8BE5A12D82784F7C] PRIMARY KEY CLUSTERED 
(
	[carID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [nvarchar](30) NULL,
	[status] [int] NULL,
 CONSTRAINT [PK__category__D54EE9B485A65D51] PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[discount]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[discount](
	[d_id] [int] IDENTITY(1,1) NOT NULL,
	[d_name] [nvarchar](50) NULL,
	[d_percent] [float] NULL,
	[d_day] [date] NULL,
 CONSTRAINT [PK__discount__D95F582BF36BE8B9] PRIMARY KEY CLUSTERED 
(
	[d_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[discountCheck]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[discountCheck](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[d_id] [int] NULL,
	[userId] [int] NULL,
 CONSTRAINT [PK__discount__3213E83FDF5E2B75] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orderCar]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderCar](
	[orderId] [int] IDENTITY(1,1) NOT NULL,
	[accountID] [int] NULL,
	[create_date] [date] NULL,
	[total_price] [float] NULL,
	[discount] [int] NULL,
	[shipping_id] [int] NULL,
 CONSTRAINT [PK__orderBoo__0809335DBFD502F0] PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orderCar_Detail]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderCar_Detail](
	[order_detailID] [int] IDENTITY(1,1) NOT NULL,
	[orderId] [int] NULL,
	[product_id] [int] NULL,
	[product_name] [nvarchar](500) NULL,
	[product_price] [float] NULL,
	[quantity] [int] NULL,
	[product_image] [nvarchar](100) NULL,
 CONSTRAINT [PK__orderBoo__1CCF4155D5574E13] PRIMARY KEY CLUSTERED 
(
	[order_detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shipping]    Script Date: 8/24/2021 11:16:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shipping](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL,
	[address] [nvarchar](200) NULL,
	[note] [nvarchar](2000) NULL,
 CONSTRAINT [PK__Shipping__3213E83FB268418D] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([userId], [userName], [password], [displayName], [address], [phone], [roll_id], [status], [create_date]) VALUES (1, N'Hoang', N'123456', N'Minh Hoang', N'Ho Chi Minh', N'0901067804', 1, 1, CAST(N'2021-05-12' AS Date))
INSERT [dbo].[account] ([userId], [userName], [password], [displayName], [address], [phone], [roll_id], [status], [create_date]) VALUES (2, N'Client2', N'123456', N'Nhi', N'Dong Thap', N'0774742256', 1, 0, CAST(N'2021-05-12' AS Date))
INSERT [dbo].[account] ([userId], [userName], [password], [displayName], [address], [phone], [roll_id], [status], [create_date]) VALUES (3, N'Admin', N'123456', N'Hoang', N'Hoc Mon', N'0828191299', 2, 1, CAST(N'2021-05-12' AS Date))
INSERT [dbo].[account] ([userId], [userName], [password], [displayName], [address], [phone], [roll_id], [status], [create_date]) VALUES (23, N'tester', N'123456', N'ThuyDT', N'Hoc Mon', N'0906129926', 1, 1, CAST(N'2021-05-17' AS Date))
INSERT [dbo].[account] ([userId], [userName], [password], [displayName], [address], [phone], [roll_id], [status], [create_date]) VALUES (24, N'Tes', N'123', N'Hoang', N'Tes', N'0945120067', 1, 1, CAST(N'2021-08-17' AS Date))
SET IDENTITY_INSERT [dbo].[account] OFF
GO
SET IDENTITY_INSERT [dbo].[Car] ON 

INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (1, 3, N'Audi A8', 10, 10, N'AUDI
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    ', N'White', N'23.jpg', CAST(N'2021-05-11' AS Date), 1)
INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (2, 3, N'Audi Q9', 96, 107, N'AUDI
                                    
                                    ', N'Black', N'20.jpg', CAST(N'2021-05-11' AS Date), 1)
INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (3, 2, N'Mercedes GLC', 45, 168, N'MERCEDES', N'White', N'21.jpg', CAST(N'2021-05-11' AS Date), 1)
INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (4, 2, N'Mercedes E200', 48, 256, N'MERCEDES', N'White', N'23.jpg', CAST(N'2021-05-11' AS Date), 1)
INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (5, 1, N'BMW i8', 47, 1000, N'BMW', N'Green', N'28.jpg', CAST(N'2021-05-11' AS Date), 1)
INSERT [dbo].[Car] ([carID], [category_id], [car_name], [quantity], [price], [description], [color], [image], [create_date], [status]) VALUES (6, 1, N'BMW Sport', 47, 1000, N'BMW
                                    ', N'Green', N'27.jpg', CAST(N'2021-05-11' AS Date), 1)
SET IDENTITY_INSERT [dbo].[Car] OFF
GO
SET IDENTITY_INSERT [dbo].[category] ON 

INSERT [dbo].[category] ([category_id], [categoryName], [status]) VALUES (1, N'BMW', 1)
INSERT [dbo].[category] ([category_id], [categoryName], [status]) VALUES (2, N'MERCEDES', 1)
INSERT [dbo].[category] ([category_id], [categoryName], [status]) VALUES (3, N'AUDI', 1)
SET IDENTITY_INSERT [dbo].[category] OFF
GO
SET IDENTITY_INSERT [dbo].[discount] ON 

INSERT [dbo].[discount] ([d_id], [d_name], [d_percent], [d_day]) VALUES (1, N'Phu', 60, CAST(N'2021-08-13' AS Date))
INSERT [dbo].[discount] ([d_id], [d_name], [d_percent], [d_day]) VALUES (3, N'sale', 30, CAST(N'2021-08-16' AS Date))
INSERT [dbo].[discount] ([d_id], [d_name], [d_percent], [d_day]) VALUES (4, N'sale1', 50, CAST(N'2021-08-16' AS Date))
INSERT [dbo].[discount] ([d_id], [d_name], [d_percent], [d_day]) VALUES (5, N'Sale2', 60, CAST(N'2021-08-17' AS Date))
SET IDENTITY_INSERT [dbo].[discount] OFF
GO
SET IDENTITY_INSERT [dbo].[discountCheck] ON 

INSERT [dbo].[discountCheck] ([id], [d_id], [userId]) VALUES (1, 1, 1)
INSERT [dbo].[discountCheck] ([id], [d_id], [userId]) VALUES (2, 3, 1)
INSERT [dbo].[discountCheck] ([id], [d_id], [userId]) VALUES (3, 3, 1)
SET IDENTITY_INSERT [dbo].[discountCheck] OFF
GO
SET IDENTITY_INSERT [dbo].[orderCar] ON 

INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (1, 1, CAST(N'2021-08-13' AS Date), 5346, 1, 1)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (2, 1, CAST(N'2021-08-15' AS Date), 429, NULL, 2)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (3, 1, CAST(N'2021-08-17' AS Date), 134.75, 3, 3)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (4, 1, CAST(N'2021-08-17' AS Date), 134.75, 3, 4)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (5, 1, CAST(N'2021-08-17' AS Date), 107, NULL, 5)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (6, 1, CAST(N'2021-08-17' AS Date), 4246, NULL, 6)
INSERT [dbo].[orderCar] ([orderId], [accountID], [create_date], [total_price], [discount], [shipping_id]) VALUES (7, 1, CAST(N'2021-08-17' AS Date), 275, NULL, 7)
SET IDENTITY_INSERT [dbo].[orderCar] OFF
GO
SET IDENTITY_INSERT [dbo].[orderCar_Detail] ON 

INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (1, 1, 2, N'Audi Q9', 107, 45, N'20.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (2, 1, 1, N'Audi A8', 171, 50, N'19.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (3, 2, 1, N'Phu3', 77, 2, N'23.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (4, 2, 2, N'Audi Q9', 107, 1, N'20.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (5, 2, 3, N'Mercedes GLC', 168, 1, N'21.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (6, 3, 3, N'Mercedes GLC', 168, 1, N'21.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (7, 3, 2, N'Audi Q9', 107, 1, N'20.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (8, 5, 2, N'Audi Q9', 107, 1, N'20.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (9, 6, 5, N'BMW i8', 1000, 2, N'28.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (10, 6, 1, N'Audi A8', 77, 14, N'23.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (11, 6, 3, N'Mercedes GLC', 168, 1, N'21.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (12, 6, 6, N'BMW Sport', 1000, 1, N'27.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (13, 7, 3, N'Mercedes GLC', 168, 1, N'21.jpg')
INSERT [dbo].[orderCar_Detail] ([order_detailID], [orderId], [product_id], [product_name], [product_price], [quantity], [product_image]) VALUES (14, 7, 2, N'Audi Q9', 107, 1, N'20.jpg')
SET IDENTITY_INSERT [dbo].[orderCar_Detail] OFF
GO
SET IDENTITY_INSERT [dbo].[Shipping] ON 

INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (1, N'Phu', N'0945120067', N'Phu', N'Phu')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (2, N'Hoang', N'0945120067', N'Tes', N'Tes')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (3, N'Hoang', N'0945120067', N'Tes', N'A')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (4, N'Hoang', N'0945120067', N'Tes', N'A')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (5, N'Hoang', N'0945120067', N'Tes', N'A')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (6, N'Hoang', N'0945120067', N'Tes', N'A')
INSERT [dbo].[Shipping] ([id], [name], [phone], [address], [note]) VALUES (7, N'Hoang', N'0945120067', N'Tes', N'g')
SET IDENTITY_INSERT [dbo].[Shipping] OFF
GO
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [DF_account_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[Car] ADD  CONSTRAINT [DF_Book_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[discount] ADD  CONSTRAINT [DF_discount_d_day]  DEFAULT (getdate()) FOR [d_day]
GO
ALTER TABLE [dbo].[orderCar] ADD  CONSTRAINT [DF_orderBook_create_date]  DEFAULT (getdate()) FOR [create_date]
GO
ALTER TABLE [dbo].[Car]  WITH CHECK ADD  CONSTRAINT [FK__Book__status__35BCFE0A] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([category_id])
GO
ALTER TABLE [dbo].[Car] CHECK CONSTRAINT [FK__Book__status__35BCFE0A]
GO
ALTER TABLE [dbo].[discountCheck]  WITH CHECK ADD  CONSTRAINT [FK__discountCh__d_id__4BAC3F29] FOREIGN KEY([d_id])
REFERENCES [dbo].[discount] ([d_id])
GO
ALTER TABLE [dbo].[discountCheck] CHECK CONSTRAINT [FK__discountCh__d_id__4BAC3F29]
GO
ALTER TABLE [dbo].[orderCar]  WITH CHECK ADD  CONSTRAINT [FK__orderBook__accou__30F848ED] FOREIGN KEY([accountID])
REFERENCES [dbo].[account] ([userId])
GO
ALTER TABLE [dbo].[orderCar] CHECK CONSTRAINT [FK__orderBook__accou__30F848ED]
GO
ALTER TABLE [dbo].[orderCar]  WITH CHECK ADD  CONSTRAINT [FK__orderBook__disco__5812160E] FOREIGN KEY([discount])
REFERENCES [dbo].[discount] ([d_id])
GO
ALTER TABLE [dbo].[orderCar] CHECK CONSTRAINT [FK__orderBook__disco__5812160E]
GO
ALTER TABLE [dbo].[orderCar]  WITH CHECK ADD  CONSTRAINT [FK__orderBook__shipp__6FE99F9F] FOREIGN KEY([shipping_id])
REFERENCES [dbo].[Shipping] ([id])
GO
ALTER TABLE [dbo].[orderCar] CHECK CONSTRAINT [FK__orderBook__shipp__6FE99F9F]
GO
ALTER TABLE [dbo].[orderCar_Detail]  WITH CHECK ADD  CONSTRAINT [FK__orderBook__produ__38996AB5] FOREIGN KEY([orderId])
REFERENCES [dbo].[orderCar] ([orderId])
GO
ALTER TABLE [dbo].[orderCar_Detail] CHECK CONSTRAINT [FK__orderBook__produ__38996AB5]
GO
ALTER TABLE [dbo].[orderCar_Detail]  WITH CHECK ADD  CONSTRAINT [FK__orderBook__produ__398D8EEE] FOREIGN KEY([product_id])
REFERENCES [dbo].[Car] ([carID])
GO
ALTER TABLE [dbo].[orderCar_Detail] CHECK CONSTRAINT [FK__orderBook__produ__398D8EEE]
GO
USE [master]
GO
ALTER DATABASE [Car] SET  READ_WRITE 
GO
