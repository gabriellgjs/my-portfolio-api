resource "aws_security_group" "portfolio_sg" {
  name = "my_portfolio_api_sg"
  description = "my portfolio api security group"
  vpc_id = aws_vpc.portfolio_vpc.id
}

resource "aws_security_group_rule" "sg_rules_out_pub" {
  from_port         = 0
  protocol          = "-1"
  security_group_id = aws_security_group.portfolio_sg.id
  to_port           = 0
  type              = "egress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "sg_rules_ssh_in" {
  from_port         = 22
  protocol          = "tcp"
  security_group_id = aws_security_group.portfolio_sg.id
  to_port           = 22
  type              = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "sg_rules_http_in" {
  from_port         = 80
  protocol          = "tcp"
  security_group_id = aws_security_group.portfolio_sg.id
  to_port           = 80
  type              = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_key_pair" "portfolio_key" {
  key_name = "portfolio_key"
  public_key = file("~/.ssh/myportfolioapi_key.pub")
}