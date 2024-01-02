resource "aws_vpc" "portfolio_vpc" {
  cidr_block = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support = true

  tags = {
    "Name": "my_portfolio_api_vpc_1"
  }
}

resource "aws_subnet" "portfolio_subnet" {
  vpc_id     = aws_vpc.portfolio_vpc.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "us-east-1a"
  map_public_ip_on_launch = true

  tags = {
    Name = "my_portfolio_api_subnet_pub"
  }
}

resource "aws_internet_gateway" "portfolio_int_gat" {
  vpc_id = aws_vpc.portfolio_vpc.id

  tags = {
    Name = "my_portfolio_api_int_gat"
  }
}

resource "aws_route_table" "portfolio_route_table" {
  vpc_id = aws_vpc.portfolio_vpc.id


  tags = {
    Name = "my_portfolio_api_route_table"
  }
}

resource "aws_route" "portfolio_route" {
  route_table_id = aws_route_table.portfolio_route_table.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id = aws_internet_gateway.portfolio_int_gat.id
}

resource "aws_route_table_association" "portfolio_rtb_association" {
  route_table_id = aws_route_table.portfolio_route_table.id
  subnet_id = aws_subnet.portfolio_subnet.id
}

resource "aws_instance" "portfolio_ec2_instance" {
  instance_type = "t2.micro"
  key_name = aws_key_pair.portfolio_key.id
  vpc_security_group_ids = [aws_security_group.portfolio_sg.id]
  subnet_id = aws_subnet.portfolio_subnet.id

  ami = data.aws_ami.portfolio_ami.id
  user_data = file("userdata.tpl")

  root_block_device {
    volume_size = 8
  }

  tags = {
    Name = "my_portfolio_api_ec2"
  }
}